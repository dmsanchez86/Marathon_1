/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marathon;

/**
 *
 * @author PCSMART-SISTEMAS
 */
public class Runner {
    protected int RunnerId;
    protected int CharityId;
    protected int RegistrationId;
    protected String FirstName;
    protected String LastName;
    protected String BibNumber;
    protected String CountryCode;

    public Runner(int RunnerId, String FirstName, String LastName, String BibNumber, String CountryCode, int CharityId, int RegistrationId) {
        this.RunnerId = RunnerId;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.BibNumber = BibNumber;
        this.CountryCode = CountryCode;
        this.CharityId = CharityId;
        this.RegistrationId = RegistrationId;
    }

    public int getRunnerId() {
        return RunnerId;
    }

    public void setRunnerId(int RunnerId) {
        this.RunnerId = RunnerId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getBibNumber() {
        return BibNumber;
    }

    public void setBibNumber(String BibNumber) {
        this.BibNumber = BibNumber;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String CountryCode) {
        this.CountryCode = CountryCode;
    }
    
    public int getIdCharity() {
        return CharityId;
    }
    
    public void setCharityId(int CharityId) {
        this.CharityId = CharityId;
    }
    
    public int getRegistrationId() {
        return RegistrationId;
    }
    
    public void setRegistrationId(int RegistrationId) {
        this.RegistrationId = RegistrationId;
    }

    @Override
    public String toString() {
        return LastName + ", " + FirstName + " - " + BibNumber + " (" + CountryCode + ')';
    }   
    
}
