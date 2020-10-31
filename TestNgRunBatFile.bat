set projectLocation=C:\Users\Administrator\eclipse-workspace\MySdetPomProject
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java org.testng.TestNG %projectLocation%\Smoke_Tests.xml
pause