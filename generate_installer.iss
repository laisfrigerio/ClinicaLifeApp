; Copyright (C) 2017 Lais Frigério da Silva - laaisfrigerio@gmail.com
; Studying of system analysis from University Federal do Paraná - UFPR
;
; This file is part of clinica-life desktop app
;
; This program is free software; you can redistribute it and/or
; modify it under the terms of the GNU General Public License
; as published by the Free Software Foundation; either version 2
; of the License, or (at your option) any later version.
;
; This program is distributed in the hope that it will be useful,
; but WITHOUT ANY WARRANTY; without even the implied warranty of
; MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
; GNU General Public License for more details.
;
; You should have received a copy of the GNU General Public License
; along with this program; if not, write to the Free Software
; Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301,
; USA.
; idpoint proxyConf( host port usr passwd   ) webService

; Macros
; Example:
; if not send from command line idp value, exists default idp value = "0";

[Setup]
AppName=Clinica Life Instalador
AppVersion=1.0.0
DefaultDirName=C:\Clinica Life
OutputDir=.
OutputBaseFilename=Clinica Life Instalador v-2.0.0
SetupIconFile=C:\Users\laisf\Documents\NetBeansProjects\ClinicaLifeApp\doctor.ico
DisableDirPage=no

[Files]
Source: "Clinica Life App.exe"; DestDir: "{app}"; DestName : "Clinica Life App.exe"

[Run]
; Modifying name from default uninstall .exe file
Filename: {cmd}; Parameters: "/C Move ""{app}\unins000.exe"" ""{app}\desinstalador.exe"""; Flags: RunHidden WaitUntilTerminated;
Filename: {cmd}; Parameters: "/C Move ""{app}\unins000.dat"" ""{app}\desinstalador.dat"""; Flags: RunHidden WaitUntilTerminated;

[Icons]
Name: "{group}\doctor"; Filename: "{app}\Clinica Life.exe"; IconFilename: "C:\Users\laisf\Documents\NetBeansProjects\TesteClinica\doctor.ico"
Name: "{group}\{cm:UninstallProgram,IconImage}"; Filename: "{uninstallexe}"; IconFilename: "C:\Users\laisf\Documents\NetBeansProjects\TesteClinica\doctor.ico"

;[Registry]
;Root: HKLM; Subkey: "SYSTEM\CurrentControlSet\Control\Session Manager\Environment"; \
    ;ValueType: expandsz; ValueName: "Path"; ValueData: "{olddata};C:\{app}"