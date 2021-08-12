/* Jennifer Minnich
 ** jminnich@cnm.edu
 ** Program 4: Using JavaFx to create GUI
 ** Controller.java
 */

package sample;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import java.io.File;

public class Controller {

    @FXML
    private TextArea taSummary;

    @FXML
    private ComboBox<String> comboBoxMain;

    @FXML
    private TextField tfPersonalizeLeft;

    @FXML
    private TextField tfPersonalizeRight;

    @FXML
    private Slider sliderMain;

    @FXML
    private RadioButton rBtnOneGroupTwo;

    @FXML
    private ToggleGroup rBtnGroupTwo;

    @FXML
    private RadioButton rBtnTwoGroupTwo;

    @FXML
    private RadioButton rBtnThreeGroupTwo;

    @FXML
    private RadioButton rBtnOneGroupOne;

    @FXML
    private ToggleGroup rBtnGroupOne;

    @FXML
    private RadioButton rBtnTwoGroupOne;

    @FXML
    private RadioButton rBtnThreeGroupOne;

    @FXML
    private CheckBox chkBoxOne;

    @FXML
    private CheckBox chkBoxTwo;

    @FXML
    private CheckBox chkBoxThree;

    @FXML
    private Button btnMake;

    @FXML
    private Button btnSave;

    @FXML
    private Label lblPrice;

    @FXML
    private ObservableList<String> dropDown;

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfEmail;

    private P4Data data;

    private Font oldFont;

    private int price = 0;

    private Double priceHigh = 175.00;

    private Double priceLow = 95.00;
    //private Double priceFinal = 0.0;



    @FXML
    private void initialize() {
        //new Data instance
        data = new P4Data();
        //button groups
        this.rBtnOneGroupOne.setSelected(true);
        price += priceLow;
        this.rBtnOneGroupTwo.setSelected(true);
        price += priceLow;
        //comboBox
        this.dropDown = FXCollections.observableArrayList(new String[]{"Beats Theme", "Air Pod Theme", "Sound Sport Theme", "Noise Cancelling Theme"});
        this.comboBoxMain.setItems(this.dropDown);
        this.comboBoxMain.setValue("Beats Theme");
        price += priceHigh;
        //slider
        this.sliderMain.setValue(50);
        price += priceLow;
        // price label
        String priceString = Integer.toString(price);
        this.lblPrice.setText("Base model preselected.\nPrice: $" + priceString
            + "\nClick features to see individual pricing.");
    }

    @FXML
    void sliderAction(MouseEvent event) {
        if (sliderMain.getValue() == 50) {
            this.lblPrice.setText("$95");
            //priceFinal += priceLow;
        } else if (sliderMain.getValue() == 100) {
            this.lblPrice.setText("$175");
            //priceFinal += priceHigh;
        } else {
            this.lblPrice.setText("");
        }
        data.setVolume((int) sliderMain.getValue());
    }

    @FXML
    void btnSaveAction(ActionEvent event) throws Exception {
        data.setName(tfName.getText());
        data.setEmail(tfEmail.getText());

        String theme = comboBoxMain.getValue();
        data.setTheme(theme);

        String left = tfPersonalizeLeft.getText();
        data.setLeft(left);

        String right = tfPersonalizeRight.getText();
        data.setRight(right);

        String addOn1 = chkBoxOne.getText();
        data.setAddOn1(addOn1);

        String addOn2 = chkBoxTwo.getText();
        data.setAddOn2(addOn2);

        String addOn3 = chkBoxThree.getText();
        data.setAddOn3(addOn3);

        RadioButton selectedRadioButton = (RadioButton) this.rBtnGroupOne.getSelectedToggle();
        RadioButton selectedRadioButton2 = (RadioButton) this.rBtnGroupTwo.getSelectedToggle();

        String toggleColor = selectedRadioButton.getText();
        data.setToggleColor(toggleColor);

        String toggleFinish = selectedRadioButton2.getText();
        data.setToggleFinish(toggleFinish);

        int volume = (int) sliderMain.getValue();
        data.setVolume(volume);

        FileChooser chooser = new FileChooser();
        File file = chooser.showSaveDialog(null);
        if (file != null) {
            data.writeFile(file);
        }
    }

    @FXML
    void chkBoxOneAction(ActionEvent event) {
        if (chkBoxOne.isSelected() && chkBoxTwo.isSelected()) {
            this.lblPrice.setText("$350");
            //priceFinal += priceHigh * 2;
        } else if (chkBoxOne.isSelected()) {
            this.lblPrice.setText("$175");
            //priceFinal += priceHigh;
        } else {
            this.lblPrice.setText("");
        }


        if (chkBoxThree.isSelected() && chkBoxOne.isSelected()) {
            this.lblPrice.setText("$350");
            //priceFinal += priceHigh * 2;
        }


        if (chkBoxThree.isSelected() && chkBoxTwo.isSelected() && chkBoxOne.isSelected()) {
            this.lblPrice.setText("$525");
            //priceFinal += priceHigh * 3;
        }

    }

    @FXML
    void chkBoxThreeAction(ActionEvent event) {
        if (chkBoxThree.isSelected()) {
            this.lblPrice.setText("$175");
            //priceFinal += priceHigh;
        } else {
            this.lblPrice.setText("");
        }

        if (chkBoxThree.isSelected() && chkBoxTwo.isSelected()) {
            this.lblPrice.setText("$350");
            //priceFinal += priceHigh * 2;
        }

        if (chkBoxThree.isSelected() && chkBoxOne.isSelected()) {
            this.lblPrice.setText("$350");
        }

        if (chkBoxThree.isSelected() && chkBoxTwo.isSelected() && chkBoxOne.isSelected()) {
            this.lblPrice.setText("$525");
        }

    }

    @FXML
    void chkBoxTwoAction(ActionEvent event) {
        if (chkBoxTwo.isSelected()) {
            this.lblPrice.setText("$175");
            //priceFinal += priceHigh;
        } else {
            this.lblPrice.setText("");
        }

        if (chkBoxOne.isSelected() && chkBoxTwo.isSelected()) {
            this.lblPrice.setText("$350");
        }

        if (chkBoxThree.isSelected() && chkBoxTwo.isSelected()) {
            this.lblPrice.setText("$350");
        }

    }

    @FXML
    void comboBoxMainAction(ActionEvent event) {
        this.lblPrice.setText("$175");
        //priceFinal += priceHigh;

    }

    @FXML
    void rBtnGroupOneAction(ActionEvent event) {
        RadioButton selectedRadioButton = (RadioButton) this.rBtnGroupOne.getSelectedToggle();
        if (selectedRadioButton == this.rBtnOneGroupOne) {
            this.lblPrice.setText("$95");
            //priceFinal += priceLow;
        } else if (selectedRadioButton == this.rBtnTwoGroupOne) {
            this.lblPrice.setText("$95");
            //priceFinal += priceLow;
        } else if (selectedRadioButton == this.rBtnThreeGroupOne) {
            this.lblPrice.setText("$175");
            //priceFinal += priceHigh;
        }

    }


    @FXML
    void rBtnGroupTwoAction(ActionEvent event) {
        RadioButton selectedRadioButton = (RadioButton) this.rBtnGroupTwo.getSelectedToggle();
        if (selectedRadioButton == this.rBtnOneGroupTwo) {
            this.lblPrice.setText("95");
            //priceFinal += priceLow;
        } else if (selectedRadioButton == this.rBtnTwoGroupTwo) {
            this.lblPrice.setText("$95");
            //priceFinal += priceLow;
        } else if (selectedRadioButton == this.rBtnThreeGroupTwo) {
            this.lblPrice.setText("$175");
            //priceFinal += priceHigh;
        }

    }

    @FXML
    void onActionMouseEntered() {
        oldFont = btnSave.getFont();
        Font font = Font.font("Times New Roman", FontWeight.BOLD, 14);
        btnSave.setFont(font);
    }

    @FXML
    void onActionMouseEntered2() {
        oldFont = btnSave.getFont();
        Font font = Font.font("Times New Roman", FontWeight.BOLD, 14);
        btnMake.setFont(font);
    }

    @FXML
    void onActionMouseExited() {
        btnSave.setFont(oldFont);
    }

    @FXML
    void onActionMouseExited2() {
        btnMake.setFont(oldFont);
    }

    @FXML
    void btnMakeAction(ActionEvent event) {

        String theme = comboBoxMain.getValue();
        int volume = (int) sliderMain.getValue();
        RadioButton selectedRadioButton = (RadioButton) this.rBtnGroupOne.getSelectedToggle();
        RadioButton selectedRadioButton2 = (RadioButton) this.rBtnGroupTwo.getSelectedToggle();
        String toggleColor = selectedRadioButton.getText();
        String toggleFinish = selectedRadioButton2.getText();
        String left = tfPersonalizeLeft.getText();
        String right = tfPersonalizeRight.getText();
        String addOn1= "";
        String addOn2= "";
        String addOn3= "";
        String quote = "\"";

        if (chkBoxOne.isSelected()) {
            addOn1 = chkBoxOne.getText();
        }

        if (chkBoxTwo.isSelected()) {
            addOn2 = chkBoxTwo.getText();
        }

        if (chkBoxThree.isSelected()) {
            addOn3 = chkBoxThree.getText();
        }

        this.taSummary.setText("Theme: " + theme + "\n"
                + "Volume Boost: " + volume + "\n"
                + "Color: " + toggleColor + "\n"
                + "Finish: " + toggleFinish + "\n"
                + "Personalized left ear: " + quote + left + quote + "\n"
                + "Personalized right ear: " + quote + right + quote + "\n"
                + "Add Ons: " + addOn1 + ", " + addOn2 + ", " + addOn3 + "\n");

    }


    @FXML
    void tfPersonalizeRightAction(ActionEvent event) {
    }

    @FXML
    void tfPersonalizeLeftAction(ActionEvent actionEvent) {
    }

    @FXML
    void onActionMouseClicked(MouseEvent mouseEvent) {
        lblPrice.setText("$95");
    }
}