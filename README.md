# Campus Tester

This program is meant as a studying aide and should not be used without the source material (e.g. lecture notes).

While everyone is welcome to use this however they want, including editing it, I only ask that you include credit.

As a note, some of the questions included are in German. Cut me some slack if you find some errors, I'm not a native speaker.
***
## How to Use
The simplest way to use this application is to clone or download the contents of this repository. I personally used IntelliJ Idea to write and run it. Simply open IntelliJ and run the application via Gradle. Note that you might need to have installed a JavaFX SDK to run this. I recommend to use version 23.0.1, but I can also confirm that it works with version 17.0.6. I suggest you try the version you have installed, and if you encounter any errors, handle them accordingly.

Once started, you should pick a course from the top-menu (e.g. "DigiCom Tests"). After starting the test, pressing the "_skip_" button will skip the question. Note that this will be counted the same as having answered the question wrong.

## Adding your own Content
If you would like to add your own tests or improve on some of the tests I have made, then feel free to do so. I will include a short tutorial on how to do so below.

### Editing existing Questions
To edit any of the existing tests or questions, then simply navigate to the "_resources_" folder. You can find it under /src/main/resources/.
There, pick one of the tests (might be in another folder depending on topic) and simply open the file. All questions are stored in .txt files.

Note that questions follow this format: "text;boolean"

Any deviation from that format might cause problems. Make sure questions are not overly long and that each question is restricted to a singular line in the file.
The files do not have any restrictions on length, so go crazy.

### Creating your own Tests
This is a bit more complex. For this, you'll need to create a menu in the top menu bar to store your question. Then add into it a menu item. This menu item should be linked to the function that will execute your test.
See "runTeamSuper()" in Controller.java for an example. After this is done, you should modify runTest(int i) in Controller.java to work with your new function.
For this, you will also need to input the file path to the new txt file that will hold your questions. 

Speaking of which, you will need to create a new .txt file that will hold your questions. The program should be able to parse the questions independent of language as long as you follow this format: "question text;boolean value".
