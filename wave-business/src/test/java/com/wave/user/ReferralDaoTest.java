package com.wave.user;

import com.wave.address.AddressData;
import com.wave.address.dao.AddressDao;
import com.wave.contact.ContactData;
import com.wave.contact.dao.ContactDao;
import com.wave.gender.Gender;
import com.wave.master.EthnicityData;
import com.wave.master.TitleData;
import com.wave.name.NameData;
import com.wave.name.dao.NameDao;
import com.wave.note.NoteData;
import com.wave.patient.PatientData;
import com.wave.patient.dao.PatientDao;
import com.wave.referral.ReferralData;
import com.wave.referral.dao.ReferralDao;
import com.wave.referrer.ReferrerData;
import com.wave.referrer.dao.ReferrerDao;
import com.wave.role.RoleDao;
import com.wave.role.RoleData;
import com.wave.user.dao.UserDao;
import com.wave.user.dao.UserData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import static junit.framework.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/wave-business-context.xml")
@Transactional
public class ReferralDaoTest {

    @Autowired
    private ReferralDao referralDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private AddressDao addressDao;

    @Autowired
    private ContactDao contactDao;

    @Autowired
    private NameDao nameDao;

    @Autowired
    private ReferrerDao referrerDao;

    @PersistenceContext
    EntityManager em;

    ReferralData referralData;

    @BeforeTransaction
    public void onSetupBeforeTransaction(){

    }

    @Test
    public void shouldSaveAndRetieveReferralData() {
        System.err.println("testUser1");

        referralData = getReferralData();

        referralDao.saveReferralData(referralData);

       /* em.clear();
        ReferralData referralData1 = referralDao.getReferralData(referralData.getId());
        referralDao.saveReferralData(referralData1);

        em.clear();
        referralData1 = referralDao.getReferralData(referralData.getId());
        referralDao.saveReferralData(referralData1);
*/
        ReferralData referralData1 = referralDao.getReferralData(referralData.getId());

        assertEquals(referralData.getCreateDate(), referralData1.getCreateDate());

        NoteData noteData = referralData1.getNotes().get(0);

        assertEquals("test note", noteData.getNote());
//        assertEquals(2, referralData1.getVersion());

    }

    private PatientData getPatientData() {
        PatientData patient = new PatientData();
        patient.setLastUpdated(new Date());
        patient.setNhsNumber("123");
        AddressData address = getAddressData();


        patient.setAddress(address);


        patient.setContactDetails(getContactDetails());

        patient.setNameData(getNameData());


        patient.setEthnicity(getEthnicity());

        patient.setGender(getGender());
        patientDao.savePatientData(patient);
        return patient;
    }

    private Gender getGender() {
        return Gender.MALE;
    }

    private EthnicityData getEthnicity() {
        EthnicityData ethnicityData = new EthnicityData();
        ethnicityData.setId(1L);
        return ethnicityData;
    }

    private NameData getNameData() {
        NameData nameData = new NameData();
        TitleData title = getTitleData();
        nameData.setTitle(title);
        nameData.setFirstName("Amit");
        nameData.setMiddleName("Amit");
        nameData.setLastName("Amit");
        nameData.setLastUpdated(new Date());
        nameData.setPreferredName("Amit");

        nameDao.saveNameData(nameData);
        return nameData;
    }

    private TitleData getTitleData() {
        TitleData titleData = new TitleData();
        titleData.setId(1L);
        titleData.setName("Mr");
        return titleData;
    }

    private ContactData getContactDetails() {
        ContactData contactData = new ContactData();
        contactData.setEmail("amit@amit.com");
        contactData.setMobile("123");
        contactData.setPhone("1234");
        contactData.setPreferred("Mobile");

        contactDao.saveContactData(contactData);
        return contactData;
    }

    private AddressData getAddressData() {
        AddressData address = new AddressData();
        address.setLine1("77nr");
        address.setLine2("22");
        address.setLine3("33");
        address.setCity("Basingstoke");
        address.setCounty("Hants");
        address.setPostCode("RG21 5QP");

        addressDao.saveAddressData(address);
        return address;
    }

    private ReferralData getReferralData() {
        ReferralData referralData = new ReferralData();
        referralData.setActive(true);
        referralData.setDescription("desc");
        referralData.setCreateDate(new Date());
        referralData.setLastUpdated(new Date());
        referralData.setType("test");
        referralData.setUbrn("123");

        PatientData patient = getPatientData();
        referralData.setPatient(patient);

        referralData.setCreatedBy(getUserData());


        referralData.setReferrerData(getReferrerData());


        ArrayList<NoteData> notes = new ArrayList<NoteData>();

        NoteData noteData = getNoteData(referralData);

        notes.add(noteData);
        referralData.setNotes(notes);
        return referralData;
    }

    private NoteData getNoteData(ReferralData referralData) {
        NoteData noteData = new NoteData();
        noteData.setCreatedBy(referralData.getCreatedBy());
        noteData.setLastUpdated(new Date());
        noteData.setNote("test note");
        return noteData;
    }

    private ReferrerData getReferrerData() {
        ReferrerData referrerData = new ReferrerData();
        referrerData.setLastUpdated(new Date());
        referrerData.setAddress(getAddressData());
        referrerData.setNameData(getNameData());
        referrerData.setContactDetails(getContactDetails());

        referrerDao.saveReferrerData(referrerData);
        return referrerData;
    }

    private UserData getUserData() {
        UserData userData = new UserData();
        userData.setUserName("testun111");
        userData.setPassword("asfdsafdss");
        userData.setEmail("a@a111.com");
        userData.setUserGuid(UUID.randomUUID().toString());
        userData.setDateOfBirth(new Date());
        userData.setCreateDate(new Date());
        userData.setGender("M");
        userData.setDisplayName("asfd");
        userData.setActive(true);


        RoleData roleData = new RoleData();
        roleData.setActive(true);
        roleData.setName("admin11111");
        roleData.setDescription("Administrator");
        roleDao.saveRoleData(roleData);

        ArrayList<RoleData> roles = new ArrayList<RoleData>();
        roles.add(roleData);
        userData.setRoles(roles);

        roleData = new RoleData();
        roleData.setActive(true);
        roleData.setName("gp11111");
        roleData.setDescription("GP");
        roleDao.saveRoleData(roleData);
        roles.add(roleData);


        userDao.saveUserData(userData);
        return userData;
    }


}
