echo "--- ElderlyMain: starting Checkstyle ---"
java -jar libs/checkstyle-8.25-all.jar -c checkers_xml/checkstyle.xml src/aufgabe2/ElderlyMain.java
echo "--- ElderlyMain:  starting PMD ---"
libs/pmd-bin-6.18.0/bin/run.sh pmd  -no-cache -d src/aufgabe2/ElderlyMain.java -f text  -R checkers_xml/pmd.xml
echo "____________________________________________________________________"
echo "--- LicenceAdministration with streams & lambdas: starting Checkstyle ---"
java -jar libs/checkstyle-8.25-all.jar -c checkers_xml/checkstyle.xml src/aufgabe3/car/LicenceAdministration.java
echo "--- LicenceAdministration:  starting PMD ---"
libs/pmd-bin-6.18.0/bin/run.sh pmd  -no-cache -d src/aufgabe3/car/LicenceAdministration.java -f text  -R checkers_xml/pmd.xml
