module edu.guilford {
    requires transitive javafx.controls;
    requires transitive javafx.fxml;

    opens edu.guilford to javafx.fxml;
    exports edu.guilford;
}
