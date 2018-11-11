/**
 * @author Lais Frigério da Silva
 */

package controller;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * Ferramenta de busca de CEP, veja o m�todo {@link WebServiceCep#searchCep(String)} para
 * maiores informa��es.
 * <BR>
 * <BR>Constroi um objeto {@link WebServiceCep} com os dados XML encapsulados, a partir
 * da chamada do m�todo estatico {@link WebServiceCep#searchCep(String)}.
 * <BR>
 * <BR>Objeto contem todas as informa��es do XML, al�m de informa��es referente ao
 * resultado da pesquisa.
 * <BR>
 * <BR>Esta ferramente depende diretamente do pacote <tt>org.dom4j</tt> para fazer o 
 * parse dos arquivos XML. O pacote dom4j.jar pode ser encontrado em 
 * <a href="http://www.dom4j.org/dom4j-1.6.1/download.html" target="_blank">dom4j.org</a>
 * <BR>
 * <BR>Exemplo de uso:
 * <BR><tt>{@link WebServiceCep} cep = {@link WebServiceCep}.searchCep("13345-325");
 * 
 * <BR>//caso a busca ocorra bem, imprime os resultados.
 * <BR>if (cep.wasSuccessful()) {
 * <BR>&nbsp; &nbsp; System.out.println("Cep: "+cep.getCep());
 * <BR>&nbsp; &nbsp; System.out.println("Logradouro: "+cep.getLogradouroFull());
 * <BR>&nbsp; &nbsp; System.out.println("Bairro: "+cep.getBairro());
 * <BR>&nbsp; &nbsp; System.out.println("Cidade: "+
 * 			cep.getCidade()+"/"+ cep.cep());
 * <BR>//caso haja problemas imprime o c�digo e msg de erro.
 * <BR>} else {
 * <BR>&nbsp; &nbsp; System.out.println("Erro n�mero: " + cep.getResulCode());
 * <BR>&nbsp; &nbsp; System.out.println("Descri��o do erro: " + cep.getResultText());
 * <BR>}
 * <BR></tt>
 * <BR>A resposta do console seria:
 * <BR><tt>
 * <BR>Cep: 13345325
 * <BR>Logradouro: Rua Cinco
 * <BR>Bairro: Jardim R�mulo Zoppi
 * <BR>Cidade: Indaiatuba/SP
 * <BR></tt>
 * <BR>Ultima revis�o: 09/01/2009
 * @author Renato Sebben
 */
public final class WebServiceCep {
	
/* Classes Internas, que auxiliam na busca do CEP */
	/**
	 * Enumeration para setar os parametros do XML, cada constante conhece o seu m�todo
	 * correspondente, invocando a partir de um atalho comum
	 * {@link Xml#setCep(String, WebServiceCep)}.
	 * @author Tomaz Lavieri
	 */
	private enum Xml {
		CIDADE {
			@Override public void setCep(String text, WebServiceCep webServiceCep) {
				webServiceCep.setCidade(text);
			}
		}, 
		BAIRRO {
			@Override public void setCep(String text, WebServiceCep webServiceCep) {
				webServiceCep.setBairro(text);
			}
		},
		TIPO_LOGRADOURO {
			@Override public void setCep(String text, WebServiceCep webServiceCep) {
				webServiceCep.setLogradouroType(text);
			}
		},
		LOGRADOURO {
			@Override public void setCep(String text, WebServiceCep webServiceCep) {
				webServiceCep.setLogradouro(text);
			}
		},
		RESULTADO {
			@Override public void setCep(String text, WebServiceCep webServiceCep) {
				webServiceCep.setResulCode(Integer.parseInt(text));
			}
		},
		RESULTADO_TXT {
			@Override public void setCep(String text, WebServiceCep webServiceCep) {
				webServiceCep.setResultText(text);
			}
		},
		UF {
			@Override public void setCep(String text, WebServiceCep webServiceCep) {
				webServiceCep.setUf(text);
			}
		}
		;
		/**
		 * Seta o texto enviado no parametro <tt>text</tt> no objeto
		 * {@link WebServiceCep} no seu parametro correspondente. Cada constante do enum
		 * conhece o seu parametro a passar.
		 * @param text {@link String} contendo o texto a ser inserido.
		 * @param webServiceCep {@link WebServiceCep} referencia do objeto para inserir
		 * 		  o parametro text.
		 */
		public abstract void setCep(String text,WebServiceCep webServiceCep);
	}
	/**
	 * Classe utilit�ria apenas encapsula o Iterator de elements da root dentro de um
	 * Iterable, para ser usado dentro de um for.
	 * @see Iterable
	 * @see Iterator
	 * @author Tomaz Lavieri
	 */
	private static final class IterableElement implements Iterable<Element> {
		private Iterator<Element> itr;
		
		@SuppressWarnings("unchecked")
		public IterableElement(Iterator<?> itr) {
			this.itr = (Iterator<Element>)itr;
		}
		@Override
		public Iterator<Element> iterator() {
			return itr;
		}
	}
	/**
	 * Classe contendo todos os Enums {@link Xml}.
	 * Tem como finalidade, buscar um Enumeration especifico pelo seu nome.
	 * @author Tomaz Lavieri
	 */
	private static final class XmlEnums {
		private HashMap<String, Xml> enumsMap;
		/**
		 * Cria um {@link XmlEnums}
		 */
		public XmlEnums() {
			initializeEnums();
		}
		/**
		 * Inicializa este objeto, guardando os enumerations em um {@link HashMap}
		 */
		private void initializeEnums() {
			Xml[] enums = Xml.class.getEnumConstants();
	    	enumsMap = new HashMap<String, Xml>();
	    	for (int i = 0; i < enums.length; i++) {
	    		enumsMap.put(enums[i].name().toLowerCase(), enums[i]);
	    	}
		}
		/**
		 * Busca um Enum {@link Xml} a partir do seu nome, a busca n�o � case sensitive,
		 * portanto o nome pode ser escrito ignorando lowercases or uppercases.
		 * @see Xml
		 * @param xmlName {@link String} contendo o nome do enumeration {@link Xml}.
		 * @return {@link Xml} correspondente ao nome enviado.
		 */
		public Xml getXml(String xmlName) {
			return enumsMap.get(xmlName.toLowerCase());
		}
	}
/* M�todos e variaveis estaticas, respons�veis pela busca do CEP */
    /**
     * Mascara para a string url de conex�o, onde <tt>"%s"</tt> � substituido pelo valor
     * do cep. 
     */
	private static final String URL_STRING = 
		"http://cep.republicavirtual.com.br/web_cep.php?cep=%s&formato=xml";

    /**
     * Carrega o Documento xml a partir do CEP enviado.
     * @param cep n�mero do cep.
     * @return {@link Document} xml WebService do site Republic Virtual
     * @throws DocumentException Quando h� problema na forma��o do documento XML.
     * @throws MalformedURLException Quando a h� problema no link url.
     */
	private static Document getDocument(String cep) 
			throws DocumentException, MalformedURLException {
		URL url = new URL(String.format(URL_STRING, cep));
		SAXReader reader = new SAXReader();
        Document document = reader.read(url);
        return document;
	}
	/**
	 * Retorna o elemento principal (root) da arvore XML.
     * @param cep n�mero do cep.
	 * @return {@link Element} principal (root) da arvore XML.
     * @throws DocumentException Quando h� problema na forma��o do documento XML.
     * @throws MalformedURLException Quando a h� problema no link url.
	 */
	private static Element getRootElement(String cep) 
			throws DocumentException, MalformedURLException {
		return getDocument(cep).getRootElement();
	}
	/**
	 * Encapsula os elementos XML dentro de um objeto
	 * <tt>{@link Iterable}<{@link Element}></tt> podendo ser recuperados um a um dentro
	 * de um for
	 * <BR>
	 * <BR>Por exemplo:
	 * <BR><tt>for (Element e : getElements(cep)) {
	 * <BR>//...
	 * <BR>}
     * @param cep n�mero do cep.
	 * @return
     * @throws DocumentException Quando h� problema na forma��o do documento XML.
     * @throws MalformedURLException Quando a h� problema no link url.
	 */
	private static IterableElement getElements(String cep) 
			throws DocumentException, MalformedURLException {
		return new IterableElement(getRootElement(cep).elementIterator());
	}
	/**
	 * Faz uma busca a partir do cep enviado, no site 
	 * <a href="http://www.republicavirtual.com.br" 
	 * target="_blank">republicavirtual.com.br</a>, retornando o resultado em um objeto
	 * {@link WebServiceCep}.
	 * <BR>
	 * <BR>N�o se faz necess�rio formata��es, a string pode ser enviada em qualquer
	 * formata��o, pois s� ser�o consideradas os primeiros 8 numeros da string.
	 * <BR>Por Exemplo:
	 * <BR>Uma <tt>{@link String} "14.568-910"</tt> � automaticamente passada para
	 * <tt>"14568910"</tt>.
	 * <BR>Uma <tt>{@link String} "1%4#5?55%16a8&910"</tt> � automaticamente passada para
	 * <tt>"14555168"</tt>, s� levando em conta os primeiros 8 n�meros.
	 * @param	cep N�mero do cep a ser carregado. S� ser�o considerados os primeiros 8 
	 * 			n�meros da {@link String} enviada. Todos os caracters n�o num�ricos ser�o
	 * 			removidos, e a string ser� truncada caso seja maior que 8 caracters.
	 * @return {@link WebServiceCep} contendo as informa��es da pesquisa.
	 */
	public static WebServiceCep searchCep(String cep) {
		cep = cep.replaceAll( "\\D*", "" ); //To numeric digits only
		if (cep.length() > 8)
			cep = cep.substring(0, 8);
		WebServiceCep loadCep = new WebServiceCep(cep);
		try {
			XmlEnums enums = new XmlEnums();
			for (Element e : getElements(cep))
				enums.getXml(e.getQualifiedName()).setCep(e.getText(), loadCep);
		} catch (DocumentException ex) {
			if (ex.getNestedException() != null && ex.getNestedException() 
					instanceof java.net.UnknownHostException) {
				loadCep.setResultText("Site n�o encontrado.");
				loadCep.setResulCode(-14);
			} else {
				loadCep.setResultText("N�o foi possivel ler o documento xml.");
				loadCep.setResulCode(-15);
			}
			loadCep.setExceptio(ex);
		} catch (MalformedURLException ex) {
			loadCep.setExceptio(ex);
			loadCep.setResultText("Erro na forma��o da url.");
			loadCep.setResulCode(-16);
		} catch (Exception ex) {
			loadCep.setExceptio(ex);
			loadCep.setResultText("Erro inesperado.");
			loadCep.setResulCode(-17);
		}
		return loadCep;
	}
	
/* Campos internos de resultado da busca */
	
	private int resulCode = -1;
	private String resultText = "busca n�o realizada.";
	private String cep = null;
	private String bairro = null;
	private String cidade = null;
	private String logradouro = null;
	private String logradouroType = null;
	private String uf = null;
	private Exception exception;
    
	
	/**
	 * Privado para que seja invocado apenas atrav�s de {@link #searchCep(String)}
	 * @param cep
	 */
    private WebServiceCep(String cep) {
    	this.cep = cep;
    }
	
	/**
	 * Exce��es lan�adas pelo {@link #searchCep(String)}.
	 * @param ex
	 */
	private void setExceptio(Exception ex) {
		this.exception = ex;
	}
/* PRIVATE m�todos set, usados pela classe Xml para setar o objeto CepWebService */
	
	private void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	private void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	private void setLogradouroType(String logradouroType) {
		this.logradouroType = logradouroType;
	}
	
	private void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	private void setResulCode(int resultado) {
		this.resulCode = resultado;
	}

	private void setResultText(String resultado_txt) {
		this.resultText = resultado_txt;
	}
	
	private void setUf(String uf) {
		this.uf = uf;
	}

/* PUBLIC m�todos get e is, usado para acessar o objeto ap�s carregado. */
	/**
	 * Informa o c�digo do resultado da pesquisa.
	 * <BR>C�digos conhecidos:
	 * <BR><tt>-1</tt> : busca n�o realizada
	 * <BR><tt>0</tt> : cep n�o encontrado
	 * <BR><tt>1</tt> : cep econtrado
	 * <BR><tt>-14</tt> : Site n�o encontrado (pode ser por problemas na internet).
	 * <BR><tt>-15</tt> : N�o foi possivel ler o documento xml
	 * <BR><tt>-16</tt> : Erro na forma��o da url
	 * <BR><tt>-17</tt> : Erro inesperado
	 * 
	 * 
	 * @return <tt>int</tt> C�digo do resultado.
	 */
	public int getResulCode() {
		return resulCode;
	}
	/**
	 * Informa��o textual sobre o resultado da pesquisa
	 * @return {@link String} contendo a descri��o do resultado da pesquisa.
	 */
	public String getResultText() {
		return resultText;
    }
	/**
	 * Informa se o cep foi encontrado com sucesso.
	 * @return	<tt>true</tt> - caso a pesquisa ache um resultado no banco.
	 * 			<BR><tt>false</tt> - caso haja falhas, ou o cep enviado n�o esteja 
	 * 			cadastrado.
	 */
	public boolean wasSuccessful() {
		return (resulCode == 1 && exception == null);
	}
	/**
	 * Informa se n�o existe o cep cadastrado.
	 * @return	<tt>true</tt> - Caso o cep n�o tenha cido encontrado.
	 * 			<BR><tt>false</tt> - Caso haja falhas, ou caso o cep esteja cadastrado.
	 */
	public boolean isCepNotFound() {
		return (resulCode == 0);
	}
	/**
	 * Informa se houve falhas na busca do cep
	 * @return	<tt>true</tt> - Caso ocorra falhas
	 * 			<BR><tt>false</tt> - Caso n�o haja falhas.
	 */
	public boolean hasException() {
		return (exception != null);
	}
	/**
	 * Pega a exce��o que ocorreu durante a busca, retorna null caso n�o haja exce��es.
	 * @return	<tt>{@link Exception}</tt> - Caso ocorra falhas
	 * 			<BR><tt>null</tt> - Caso n�o haja falhas.
	 */
	public Exception getException() {
		return exception;
	}
	/**
	 * Informa o bairro
	 * @return {@link String} contendo o nome bairro
	 */
	public String getBairro() {
		return bairro;
	}
	/**
	 * Informa a cidade
	 * @return {@link String} contendo o nome da Cidade
	 */
	public String getCidade() {
		return cidade;
	}
	/**
	 * Informa a Unidade Federativa
	 * @return {@link String} contendo o nome da Unidade Federativa
	 */
	public String getUf() {
		return uf;
	}
	/**
	 * Informa o logradouro.
	 * @return {@link String} contendo o nome do Logradouro
	 */
	public String getLogradouro() {
		return logradouro;
	}
	/**
	 * Informa o logradouro junto com o tipo de logradouro.
	 * @return {@link String} contendo o tipo de Logradouro + nome do Logradouro.
	 */
	public String getLogradouroFull() {
		return (logradouro == null || logradouroType ==null) ? null : 
			logradouroType + " " + logradouro; 
	}
	/**
	 * Informa o tipo do logradouro.
	 * @return {@link String} contendo o tipo de logradouuro.
	 */
	public String getLogradouroType() {
		return logradouroType;
	}
	/**
	 * Informa o cep.
	 * @return {@link String} contendo o cep.
	 */
	public String getCep() {
		return cep;
	}
}