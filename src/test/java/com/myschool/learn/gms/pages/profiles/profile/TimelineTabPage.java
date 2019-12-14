package com.myschool.learn.gms.pages.profiles.profile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import com.myschool.learn.gms.configuration.Config;
import com.myschool.learn.gms.pages.BasePage;

public class TimelineTabPage extends BasePage {

    public TimelineTabPage(WebDriver driver, Config config) {
        super(driver, config);
    }

    public void waitForPageLoad() {
        this.wait.until(ExpectedConditions.visibilityOf(this.timelineTabContainer));
        this.wait.until(ExpectedConditions.visibilityOf(this.searchTimelineInput));
        this.wait.until(ExpectedConditions.visibilityOf(this.filterTimelineWorkflowCheckbox));
        this.wait.until(ExpectedConditions.visibilityOf(this.filterTimelineEmailsCheckbox));
        this.wait.until(ExpectedConditions.visibilityOf(this.filterTimelineSurveyEntriesCheckbox));
        this.wait.until(ExpectedConditions.visibilityOf(this.timelineList));
    }

    @FindBy(xpath = "//div[@id='marketingTab' and contains(@class, 'active')]")
    protected WebElement timelineTabContainer;

    // timeline search Input

    @FindBy(xpath = "//input[@class='form-control input-sm searchTimeline']")
    protected WebElement searchTimelineInput;

    // timeline workflow filter checkbox

    @FindBy(xpath = "//div[@class='checkbox timeline-checkbox']/label/span[contains(text(), 'Workflows')]")
    protected WebElement filterTimelineWorkflowCheckbox;

    // timeline emails filter checkbox

    @FindBy(xpath = "//div[@class='checkbox timeline-checkbox']/label/span[contains(text(), 'Emails')]")
    protected WebElement filterTimelineEmailsCheckbox;

    // timeline survey entries filter checkbox

    @FindBy(xpath = "//div[@class='checkbox timeline-checkbox']/label/span[contains(text(), 'Survey Entries')]")
    protected WebElement filterTimelineSurveyEntriesCheckbox;

    // timeline list

    @FindBy(xpath = "//div[@id='timelineFeed']/ul")
    protected WebElement timelineList;

    public List<WebElement> getTimelineListRows() {
        return this.timelineList.findElements(By.xpath("./li[@data-entry-type='surveyEntry']"));
    }

    public Integer getTimelineListRowsCount() {
        List<WebElement> rows = this.getTimelineListRows();
        return rows.size();
    }

    public String getTimelineListItemTitle(Integer index) {
        List<WebElement> rows = this.getTimelineListRows();
        WebElement row = rows.get(index);
        return row.findElement(By.xpath(".//span[@class='timeline-title']")).getText();
    }

    public String getTimelineListItemDate(Integer index) {
        List<WebElement> rows = this.getTimelineListRows();
        WebElement row = rows.get(index);
        return row.findElement(By.xpath(".//span[@class='timeline-date']")).getText();
    }

    public String getTimelineListItemTime(Integer index) {
        List<WebElement> rows = this.getTimelineListRows();
        WebElement row = rows.get(index);
        return row.findElement(By.xpath(".//span[@class='timeline-time']")).getText();
    }

    public void clickTimelineListRowsViewSubmissionButton(Integer index) {
        List<WebElement> rows = this.getTimelineListRows();
        WebElement row = rows.get(index);
        row.findElement(By.xpath(".//div[@class='timeline-body']/a")).click();
    }

}
