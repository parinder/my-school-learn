package com.gms.pages.formscenter.survey;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.gms.configuration.Config;
import com.gms.pages.BasePage;

public class SurveyPagesTabPage extends BasePage {

	public SurveyPagesTabPage(WebDriver driver, Config config) {
		super(driver, config);
	}

	public void waitForPageLoad() {
		this.wait.until(ExpectedConditions.visibilityOf(this.addPageButton));
		this.wait.until(ExpectedConditions.visibilityOf(this.surveyPagesNavigationHelpIcon));
		this.wait.until(ExpectedConditions.visibilityOf(this.languageTranslationHelpIcon));
		this.wait.until(ExpectedConditions.visibilityOf(this.designTab));
		this.wait.until(ExpectedConditions.visibilityOf(this.htmlTab));
		this.waitForLoadingModalToBeInvisible();
	}

	// main section survey page buttons

	@FindBy(xpath = "//div[@id='pages_language_bar']/div[@class='pages']")
	protected WebElement surveyPageButtons;

	public List<WebElement> getSurveyPageButtons() {
		this.wait.until(ExpectedConditions
				.visibilityOf(this.surveyPageButtons.findElement(By.xpath(".//a[contains(@class,'ajaxGet')]"))));
		return surveyPageButtons.findElements(By.xpath(".//a[contains(@class,'ajaxGet')]"));
	}

	public Integer getSurveyPageButtonCount() {
		List<WebElement> buttons = this.getSurveyPageButtons();
		return buttons.size();
	}

	public void clickSurveyPageButton(Integer index) {
		List<WebElement> buttons = this.getSurveyPageButtons();
		WebElement button = buttons.get(index);
		button.click();
	}

	public boolean surveyPageButtonIsSelected(Integer index) {
		List<WebElement> buttons = this.getSurveyPageButtons();
		WebElement button = buttons.get(index);
		return button.getAttribute("class").contains("current");
	}

	// main section add page button

	@FindBy(xpath = "//div[@id='pages_language_bar']/div[@class='pages']/a[contains(text(), 'Add Page')]")
	protected WebElement addPageButton;

	public void clickAddPageButton() {
		this.wait.until(ExpectedConditions.visibilityOf(this.addPageButton));
		this.addPageButton.click();
	}

	// main section delete page button

	@FindBy(xpath = "//div[@id='pages_language_bar']/div[@class='pages']/a[contains(text(), 'Delete Page')]")
	protected WebElement deletePageButton;

	public void clickDeletePageButton() {
		this.wait.until(ExpectedConditions.visibilityOf(this.deletePageButton));
		this.deletePageButton.click();
	}

	// delete current page dialog

	public void waitForDeleteCurrentPageDialogIsVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.deleteCurrentPageDialogDeleteButton));
		this.wait.until(ExpectedConditions.visibilityOf(this.deleteCurrentPageDialogCancelButton));
	}

	@FindBy(xpath = "//div[@id='dialog']/form[@id='addField']/div[@id='form_nav_bar']/a[@class='icon_button saveAjaxPost']")
	protected WebElement deleteCurrentPageDialogDeleteButton;

	public void waitForDeleteCurrentPageDialogDeleteButtonIsInvisible() {
		this.wait.until(ExpectedConditions.invisibilityOf(this.deleteCurrentPageDialogDeleteButton));
	}

	public void clickDeleteCurrentPageDialogDeleteButton() {
		this.wait.until(ExpectedConditions.visibilityOf(this.deleteCurrentPageDialogDeleteButton));
		this.deleteCurrentPageDialogDeleteButton.click();
	}

	@FindBy(xpath = "//div[@id='dialog']/form[@id='addField']/div[@id='form_nav_bar']/a[@class='icon_button cancel']")
	protected WebElement deleteCurrentPageDialogCancelButton;

	public void clickDeleteCurrentPageDialogCancelButton() {
		this.wait.until(ExpectedConditions.visibilityOf(this.deleteCurrentPageDialogCancelButton));
		this.deleteCurrentPageDialogCancelButton.click();
	}

	// main section survey pages navigation help icon

	@FindBy(xpath = "//div[@class='pages']//span[@class='helpHint']")
	protected WebElement surveyPagesNavigationHelpIcon;

	// main section language help icon

	@FindBy(xpath = "//div[@id='languages']/span[@class='helpHint']")
	protected WebElement languageTranslationHelpIcon;

	// main section language dropdown

	@FindBy(xpath = "(//div[@id='languages']/div[@class='droplist']")
	protected WebElement languageDropdown;

	@FindBy(xpath = "//div[@id='languages']/div[@class='droplist']/ul[@class='list']/li[contains(text(),'Default')]")
	protected WebElement languagesDropdownDefaultMenuItem;

	public void clickLanguagesDropdownDefaultMenuItem() {
		this.wait.until(ExpectedConditions.visibilityOf(this.languagesDropdownDefaultMenuItem));
		this.languagesDropdownDefaultMenuItem.click();
	}

	// main section design tab

	@FindBy(xpath = "//div[@id='design_html']/div[contains(@class,'design')]")
	protected WebElement designTab;

	// main section html tab

	@FindBy(xpath = "//div[@id='design_html']/div[contains(@class,'html')]")
	protected WebElement htmlTab;

	// left section control panel

	public void waitForControlPanelToBeVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.controlPanelTitle));
		this.wait.until(ExpectedConditions.visibilityOf(this.undoButton));
		this.wait.until(ExpectedConditions.visibilityOf(this.redoButton));
		this.wait.until(ExpectedConditions.visibilityOf(this.previewSurveyPageButton));
		this.wait.until(ExpectedConditions.visibilityOf(this.publishSurveyButton));
	}

	@FindBy(xpath = "//div[@id='controlpanel']/h2/span[@class='cpanel']")
	protected WebElement controlPanelTitle;

	@FindBy(xpath = "//a[contains(@href,'undo')]")
	protected WebElement undoButton;

	@FindBy(xpath = "//a[contains(@href,'redo')]")
	protected WebElement redoButton;

	@FindBy(xpath = "//a[contains(@href,'preview')]")
	protected WebElement previewSurveyPageButton;

	public void clickPreviewSurveyPageButton() {
		this.wait.until(ExpectedConditions.visibilityOf(this.previewSurveyPageButton));
		this.previewSurveyPageButton.click();
	}

	@FindBy(xpath = "//a[contains(@href,'publish')]")
	protected WebElement publishSurveyButton;

	public void clickPublishSurveyButton() {
		this.wait.until(ExpectedConditions.visibilityOf(this.publishSurveyButton));
		this.publishSurveyButton.click();
	}

	// left section form elements style panel

	@FindBy(xpath = "//div[@id='formElementStyling']")
	protected WebElement formElementsStylePanel;

	public void waitForFormElementsStylePanelToBeVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.formElementsStylePanel));
		this.wait.until(ExpectedConditions.visibilityOf(this.editQuestionDisplayTypesButton));
	}

	@FindBy(xpath = "//a[@id='advancedClassRawCSS']")
	protected WebElement editQuestionDisplayTypesButton;

	public void clickEditQuestionDisplayTypesButton() {
		this.wait.until(ExpectedConditions.visibilityOf(this.editQuestionDisplayTypesButton));
		this.editQuestionDisplayTypesButton.click();
	}

	// edit question display types modal

	public void waitForEditQuestionDisplayTypesModalToBeVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.editQuestionDisplayTypesModalTitle));
	}

	@FindBy(xpath = "//div[contains(@class,'ui-dialog-titlebar')]//span[contains(text(),'Edit Question Display Types')]")
	protected WebElement editQuestionDisplayTypesModalTitle;

	@FindBy(xpath = "//div[@id='form_nav_bar']/a[@class='icon_button saveTheme']")
	protected WebElement editQuestionDisplayTypesModalSaveButton;

	@FindBy(xpath = "//div[@id='form_nav_bar']/a[@class='icon_button cancel']")
	protected WebElement editQuestionDisplayTypesModalCancelButton;

	public void clickEditQuestionDisplayTypesModalCancelButton() {
		this.wait.until(ExpectedConditions.visibilityOf(this.editQuestionDisplayTypesModalCancelButton));
		this.editQuestionDisplayTypesModalCancelButton.click();
	}

	// left section advanced style panel

	@FindBy(xpath = "//div[@id='advanced_formatting']")
	protected WebElement advancedStylePanel;

	public void waitForAdvancedStylePanelToBeVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.advancedStylePanel));
	}

	// right section palette panel

	@FindBy(xpath = "//div[@id='palette']")
	protected WebElement palettePanel;

	public void waitForPalettePanelToBeVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.palettePanel));
	}

	// right section question library panel

	@FindBy(xpath = "//div[@id='question_library']")
	protected WebElement questionLibraryPanel;

	public void waitForQuestionLibraryPanelToBeVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.questionLibraryPanel));
		this.wait.until(ExpectedConditions.visibilityOf(this.questionLibraryLink));
	}

	@FindBy(xpath = "//div[@id='question_library']/h2/a")
	protected WebElement questionLibraryLink;

	public void clickQuestionLibraryLink() {
		this.wait.until(ExpectedConditions.visibilityOf(this.questionLibraryLink));
		this.questionLibraryLink.click();
	}

	// right section registration fields panel

	@FindBy(xpath = "//div[@id='registration_elements']")
	protected WebElement registrationFieldsPanel;

	public void waitForRegistrationFieldsPanelToBeVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.registrationFieldsPanel));
	}

	// Loading Modal

	@FindBy(xpath = "//div[@id='console']/img[@id='close']")
	protected WebElement consoleCloseImg;

	@FindBy(xpath = "//div[@id='console']/img[@class='loader']")
	protected WebElement consoleLoadingImg;

	@FindBy(xpath = "//div[@id='consoleBox_overlay']")
	protected WebElement consoleOverlay;

	public void waitForLoadingModalToBeVisible() {
		this.wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOf(this.consoleCloseImg),
				ExpectedConditions.visibilityOf(this.consoleLoadingImg),
				ExpectedConditions.visibilityOf(this.consoleOverlay)));
	}

	public void waitForLoadingModalToBeInvisible() {
		this.wait.until(ExpectedConditions.and(ExpectedConditions.invisibilityOf(this.consoleCloseImg),
				ExpectedConditions.invisibilityOf(this.consoleLoadingImg),
				ExpectedConditions.invisibilityOf(this.consoleOverlay)));
	}

	public void waitForLoadingModal() {
		this.waitForLoadingModalToBeVisible();
		this.waitForLoadingModalToBeInvisible();
		this.wait.until(ExpectedConditions.elementToBeClickable(this.addPageButton));
	}
}