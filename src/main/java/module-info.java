module com.javarush.cryptoanalyzer.hayriyan.uidemofinalm1beastie {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.javarush.cryptoanalyzer.hayriyan.uidemofinalm1beastie to javafx.fxml;
    exports com.javarush.cryptoanalyzer.hayriyan.uidemofinalm1beastie;
}