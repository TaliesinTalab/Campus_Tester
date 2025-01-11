module bones.tester {
    requires javafx.controls;
    requires javafx.fxml;


    opens bones.tester to javafx.fxml;
    exports bones.tester;
}