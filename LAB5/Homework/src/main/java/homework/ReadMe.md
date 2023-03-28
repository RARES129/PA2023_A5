## Problem Description

- ✅ ️ Represent the commands using classes instead of methods. Use an interface or an abstract class in order to desribe
  a generic command.
- ✅ ️ Implement the commands load, list, view, report (create the classes AddCommand, ListCommand, etc.).
    - ✅ ️ list: prints the list of items on the screen;
    - ✅ ️ add
    - ✅ ️ save
    - ✅ ️ load
    - ✅  view: opens an item using the native operating system application (see the Desktop class);
    - ✅ ️ report: creates (and opens) an HTML report representing the content of the catalog.\
      Use a template engine such as FreeMarker or Velocity, in order to create the HTML report.
    - ✅ ️ (+1p) Use Apache Tika in order to extract metadata from your catalog items and implement the command info in order
      to display them.
- ✅ ️ The application will signal invalid date or the commands that are not valid using custom exceptions.
- ✅ ️ The final form of the application will be an executable JAR archive. Identify the generated archive and launch the
  application from the console, using the JAR.
    ![image](https://user-images.githubusercontent.com/61457770/160278639-415635b8-e071-4de4-ad8a-8960249f67ec.png)

## Bazat pe feedback-ul precedent:

- am grupat clasele in mai multe pachete in functie de responsabilitati

## Cum am gandit problema
- Am nevoie sa apelez mai multe Comenzi cu diferiti parametri, si diferiti ca si numar. In cazul asta am declarat in
interfata ca singurul contract pe care-l au de respectat comenzile este sa aiba metoda execute care sa primeasca Object.
- Am grupat comportamentul comun in CommonBehaviour si am transformat toti parametrii intr-o lista
de obiecte Object pe care fiecare metoda, in functie de arhitectura, va sti cum si cate dintre ele sa foloseasca.
- La metodele in sine care extind CommonBehaviour, contractul este reprezentat de metoda run(), prin care se face Cast
de la Object la cea ce stie metoda respectiva ca are nevoie. Se trateaza exceptiile corespunzator.

In modul acesta m-am gandit ca o sa scap de cod duplicat, preiau functionalitatea comuna intr-o clasa abstracta si plec
de la o interfata care sa dea contractul asupra modului in care ar trebui sa arate o comanda.
## Output

1. opens an item using the native operating system application (desktop = Desktop.getDesktop();)
![image](https://user-images.githubusercontent.com/61457770/160277525-59462222-882c-45d8-ac88-10692905ab2f.png)
![image](https://user-images.githubusercontent.com/61457770/160277537-5748a675-254c-437c-8fc3-eb28099712e3.png)

2. creates (and opens) an HTML report representing the content of the catalog.
![image](https://user-images.githubusercontent.com/61457770/160277580-d075d950-e4e0-4fd1-a169-113e51cdd52a.png)

3. list of items (ListCommand)
![image](https://user-images.githubusercontent.com/61457770/160277600-bb341d20-3963-43a4-9abc-ca4a5b366bfa.png)

