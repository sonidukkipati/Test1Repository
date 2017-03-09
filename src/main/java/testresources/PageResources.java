package testresources;

import org.openqa.selenium.WebDriver;
import pages.*;

/**
 * Created by sc on 2/20/2017.
 */
public class PageResources {
    //privates can be used only in that class
    private WebDriver dr;
   private AddReportEntity addReportEntity;
   private LoginPage loginPage;
   private Entities entities;
   private NavBar navBar;
   private AddReportIdentifiers addReportIdentifiers;
   private AddReportIDInformation addReportIDInformation;
   private AddReportSubjectInformation addReportSubjectInformation;
   private AddReportStopInformation addReportStopInformation;
   private AddReportVehicle addReportVehicle;
   private AddReportCommit addReportCommit;
   private AddReportPhotos addReportPhotos;
   private Reports reports;
   private Users users;
   private UserDeletion userDeletion;
   private UsersPermissionsDialog usersPermissionsDialog;

    public Reports getReports() {
        return reports;
    }

    public AddReportStopInformation getAddReportStopInformation() {
        return addReportStopInformation;
    }

    public AddReportVehicle getAddReportVehicle() {
        return addReportVehicle;
    }

    public AddReportCommit getAddReportCommit() {
        return addReportCommit;
    }

    public AddReportPhotos getAddReportPhotos() {
        return addReportPhotos;
    }

    public Users getUsers() {
        return users;
    }

    public UserDeletion getUserDeletion() {
        return userDeletion;
    }

    public UsersPermissionsDialog getUsersPermissionsDialog() {
        return usersPermissionsDialog;
    }

    public PageResources(WebDriver dr){

        this.dr=dr;
        addReportEntity = new AddReportEntity(dr);
        loginPage = new LoginPage(dr);
        entities = new Entities(dr);
        navBar = new NavBar(dr);
        addReportIdentifiers  = new AddReportIdentifiers(dr);
        addReportIDInformation = new AddReportIDInformation(dr);
        addReportSubjectInformation = new AddReportSubjectInformation(dr);
        addReportStopInformation = new AddReportStopInformation(dr);
        addReportCommit = new AddReportCommit(dr);
        addReportVehicle = new AddReportVehicle(dr);
        addReportPhotos = new AddReportPhotos(dr);
        addReportStopInformation = new AddReportStopInformation(dr);
        reports = new Reports(dr);
        users = new Users(dr);
        userDeletion = new UserDeletion(dr);
        usersPermissionsDialog = new UsersPermissionsDialog(dr);




    }

    public AddReportEntity getAddReportEntity() {
        return addReportEntity;
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public Entities getEntities() {
        return entities;
    }

    public NavBar getNavBar() {
        return navBar;
    }

    public AddReportIdentifiers getAddReportIdentifiers() {
        return addReportIdentifiers;
    }

    public AddReportIDInformation getAddReportIDInformation() {
        return addReportIDInformation;
    }

    public AddReportSubjectInformation getAddReportSubjectInformation() {
        return addReportSubjectInformation;
    }
}
