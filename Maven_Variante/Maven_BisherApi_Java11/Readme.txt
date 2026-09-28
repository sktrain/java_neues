Übersteuern der Standardregeln:

- siehe z.B:	https://nipafx.dev/five-command-line-options-hack-java-module-system/
	(bietet auch ein Java Modules Cheat Sheet: https://nipafx.dev/build-modules/)


Woher wissen wir, was in welchen Modulen enthalten ist, bzw. kennen die Modulbeschreibungen?
(alles ziemlich mühsam)

- Doku: Listet nur die offiziell angebotenen Packages auf (Export), 
        enthält jetzt auch Abhängigkeitsgraphen für die SE-Module 
- Eclipse: BuildPath-Einstellungen
- Kommandozeilen-Tools: siehe Commandline.txt






Woher kennen wir unsere Abhängigkeiten insbesondere bzgl. interner APIs?

- jdeps-Tool!!, z.B:

	C:\Program Files\Java\jdk-11.0.3\bin>jdeps --list-deps ..\..\jre1.8.0_192\lib\plugin.jar
    Warning: split package: netscape.javascript jrt:/jdk.jsobject ..\..\jre1.8.0_192\lib\plugin.jar
   JDK removed internal API/com.sun.java.browser.dom
   JDK removed internal API/com.sun.java.browser.net
   JDK removed internal API/sun.applet
   JDK removed internal API/sun.awt
   JDK removed internal API/sun.misc
   java.base/sun.net
   java.base/sun.net.www
   java.base/sun.net.www.protocol.jar
   java.base/sun.security.action
   java.base/sun.security.util
   java.desktop/java.awt.peer
   java.desktop/sun.applet
   java.desktop/sun.awt
   java.desktop/sun.awt.image
   java.desktop/sun.awt.windows
   java.logging
   java.xml
   jdk.xml.dom


- Grafische Aufbereitung des Outputs des jdeps-Tools mittels 
  des Tools graphviz (http://www.graphviz.org)
  z.B:
  
  C:\Program Files\Java\jdk-11.0.3\bin>
  	jdeps -dotoutput 
	C:\Users\stephan\workspaces\eclipse\Java_Update_2021\Test_bisherApi_Java11\graph ..\..\jre1.8.0_192\lib\plugin.jar
	Warning: split package: netscape.javascript jrt:/jdk.jsobject ..\..\jre1.8.0_192\lib\plugin.jar

  C:\Program Files\Java\jdk-11.0.3\bin>
  	cd C:\Users\stephan\workspaces\eclipse\Java_Update_2021\Test_bisherApi_Java11\graph

  C:\Users\stephan\workspaces\eclipse\Java_Update_2021\Test_bisherApi_Java11\graph> 
  	C:\Users\stephan\Programme\Graphviz\bin\dot -Tpng -Gdpi=300 summary.dot > summary.png
