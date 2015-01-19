package com.sifiso.codetribe.dvs.doctorlib.dto;

import java.util.ArrayList;

/**
 * Created by CodeTribe1 on 2014-11-14.
 */
public class RequestDTO {

    private Integer requestType, doctorID;
    private String email, pin, gcmRegistrationID, sessionID;


    public Integer getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(Integer doctorID) {
        this.doctorID = doctorID;
    }

    public Integer getRequestType() {
        return requestType;
    }

    public void setRequestType(Integer requestType) {
        this.requestType = requestType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getGcmRegistrationID() {
        return gcmRegistrationID;
    }

    public void setGcmRegistrationID(String gcmRegistrationID) {
        this.gcmRegistrationID = gcmRegistrationID;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    //register actors
    public static final int REGISTER_CLIENT = 1,
            REGISTER_DOCTOR = 2,
            REGISTER_RECEPTIONIST = 3,
            REGISTER_SURGERY = 4;

    //add data
    public static final int ADD_VISIT = 100,
            ADD_MEDICAL_AID = 101,
            ADD_DOCTOR_TYPE = 102,
            ADD_PATIENT_FILE = 104;

    //login stuff
    public static final int LOGIN_DOCTOR = 200,
            LOGIN_RECEPTIONIST = 201,
            LOGIN_CLIENT = 202;

    //update
    public static final int UPDATE_VISIT = 300,
            UPDATE_PATIENT_FILE = 301;

    //get
    public static final int GET_CLIENT_FILES = 400,
            GET_DOCTOR_DATA = 401;

    private ClientDTO client;
    private CountryDTO country;
    private DeviceerrorDTO deviceerror;
    private DoctortypeDTO doctortype;
    private MedicalaidDTO medicalaid;
    private PatientfileDTO patientfile;
    private ProvinceDTO province;
    private ReceptionistDTO receptionist;
    private ServererrorDTO servererror;
    private SurgeryDTO surgery;
    private TownshipDTO township;
    private VisitDTO visit;
    private DoctorDTO doctor;
    private GcmdeviceDTO gcmdevice;

    public static final String SURGERY_DIR = "surgery";
    public static final String DOCUMENT_DIR = "document";
    public static final String DOCTOR_DIR = "doctor";
    public static final String CLIENTS_DIR = "clients";

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }

    public CountryDTO getCountry() {
        return country;
    }

    public void setCountry(CountryDTO country) {
        this.country = country;
    }

    public GcmdeviceDTO getGcmdevice() {
        return gcmdevice;
    }

    public void setGcmdevice(GcmdeviceDTO gcmdevice) {
        this.gcmdevice = gcmdevice;
    }

    public DeviceerrorDTO getDeviceerror() {
        return deviceerror;
    }

    public void setDeviceerror(DeviceerrorDTO deviceerror) {
        this.deviceerror = deviceerror;
    }

    public DoctortypeDTO getDoctortype() {
        return doctortype;
    }

    public void setDoctortype(DoctortypeDTO doctortype) {
        this.doctortype = doctortype;
    }

    public MedicalaidDTO getMedicalaid() {
        return medicalaid;
    }

    public void setMedicalaid(MedicalaidDTO medicalaid) {
        this.medicalaid = medicalaid;
    }

    public PatientfileDTO getPatientfile() {
        return patientfile;
    }

    public void setPatientfile(PatientfileDTO patientfile) {
        this.patientfile = patientfile;
    }

    public ProvinceDTO getProvince() {
        return province;
    }

    public void setProvince(ProvinceDTO province) {
        this.province = province;
    }

    public ReceptionistDTO getReceptionist() {
        return receptionist;
    }

    public void setReceptionist(ReceptionistDTO receptionist) {
        this.receptionist = receptionist;
    }

    public ServererrorDTO getServererror() {
        return servererror;
    }

    public void setServererror(ServererrorDTO servererror) {
        this.servererror = servererror;
    }

    public SurgeryDTO getSurgery() {
        return surgery;
    }

    public void setSurgery(SurgeryDTO surgery) {
        this.surgery = surgery;
    }

    public TownshipDTO getTownship() {
        return township;
    }

    public void setTownship(TownshipDTO township) {
        this.township = township;
    }

    public VisitDTO getVisit() {
        return visit;
    }

    public void setVisit(VisitDTO visit) {
        this.visit = visit;
    }

    public DoctorDTO getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorDTO doctor) {
        this.doctor = doctor;
    }
}
