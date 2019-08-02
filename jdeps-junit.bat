jdeps libs\junit-4.12.jar libs\hamcrest-core-1.3.jar
:: jdeps -s libs\junit-4.12.jar libs\hamcrest-core-1.3.jar
:: jdeps -v libs\junit-4.12.jar libs\hamcrest-core-1.3.jar
jdeps --generate-module-info %tmp%\dotsummary libs\junit-4.12.jar libs\hamcrest-core-1.3.jar
jdeps -dotoutput %tmp%\dotsummary libs\junit-4.12.jar libs\hamcrest-core-1.3.jar
