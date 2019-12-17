echo "--- OperationsSimpleParallel: starting Checkstyle ---"
java -jar libs/checkstyle-8.25-all.jar -c checkers_xml/checkstyle.xml src/aufgaben/OperationsSimpleParallel.java
echo "--- OperationsSimpleParallel:  starting PMD ---"
libs/pmd-bin-6.18.0/bin/run.sh pmd  -no-cache -d src/aufgaben/OperationsSimpleParallel.java -f text  -R checkers_xml/pmd.xml
echo "____________________________________________________________________"
echo "--- OperationsCountDown: starting Checkstyle ---"
java -jar libs/checkstyle-8.25-all.jar -c checkers_xml/checkstyle.xml src/aufgaben/OperationsCountDown.java
echo "--- OperationsCountDown:  starting PMD ---"
libs/pmd-bin-6.18.0/bin/run.sh pmd  -no-cache -d src/aufgaben/OperationsCountDown.java -f text  -R checkers_xml/pmd.xml
echo "____________________________________________________________________"
echo "--- OperationsParallel: starting Checkstyle ---"
java -jar libs/checkstyle-8.25-all.jar -c checkers_xml/checkstyle.xml src/aufgaben/OperationsParallel.java
echo "--- OperationsParallel:  starting PMD ---"
libs/pmd-bin-6.18.0/bin/run.sh pmd  -no-cache -d src/aufgaben/OperationsParallel.java -f text  -R checkers_xml/pmd.xml
