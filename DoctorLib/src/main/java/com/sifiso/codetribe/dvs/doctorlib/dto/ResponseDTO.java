package com.sifiso.codetribe.dvs.doctorlib.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CodeTribe1 on 2014-11-14.
 */
public class ResponseDTO implements Serializable {
    private int statusCode;
    private String message, sessionID, GCMRegistrationID;

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

    private List<ClientDTO> clientList = new ArrayList<ClientDTO>();
    private List<CountryDTO> countryList = new ArrayList<CountryDTO>();
    private List<DeviceerrorDTO> deviceerrorList = new ArrayList<DeviceerrorDTO>();
    private List<DoctorDTO> doctorList = new ArrayList<DoctorDTO>();
    private List<DoctortypeDTO> doctortypeList = new ArrayList<DoctortypeDTO>();
    private List<MedicalaidDTO> medicalaidList = new ArrayList<MedicalaidDTO>();
    private List<PatientfileDTO> patientfileList = new ArrayList<PatientfileDTO>();
    private List<ProvinceDTO> provinceList = new ArrayList<ProvinceDTO>();
    private List<ReceptionistDTO> receptionistList = new ArrayList<ReceptionistDTO>();
    private List<ServererrorDTO> servererrorList = new ArrayList<ServererrorDTO>();
    private List<SurgeryDTO> surgeryList = new ArrayList<SurgeryDTO>();
    private List<TownshipDTO> townshipList = new ArrayList<TownshipDTO>();
    private List<VisitDTO> visitList = new ArrayList<VisitDTO>();
    private List<GcmdeviceDTO> gcmdeviceList = new ArrayList<GcmdeviceDTO>();

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public String getGCMRegistrationID() {
        return GCMRegistrationID;
    }

    public void setGCMRegistrationID(String GCMRegistrationID) {
        this.GCMRegistrationID = GCMRegistrationID;
    }

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

    public GcmdeviceDTO getGcmdevice() {

        return gcmdevice;
    }

    public void setGcmdevice(GcmdeviceDTO gcmdevice) {
        this.gcmdevice = gcmdevice;
    }

    public List<GcmdeviceDTO> getGcmdeviceList() {
        return gcmdeviceList;
    }

    public void setGcmdeviceList(List<GcmdeviceDTO> gcmdeviceList) {
        this.gcmdeviceList = gcmdeviceList;
    }

    public List<ClientDTO> getClientList() {
        return clientList;
    }

    public void setClientList(List<ClientDTO> clientList) {
        this.clientList = clientList;
    }

    public List<CountryDTO> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<CountryDTO> countryList) {
        this.countryList = countryList;
    }

    public List<DeviceerrorDTO> getDeviceerrorList() {
        return deviceerrorList;
    }

    public void setDeviceerrorList(List<DeviceerrorDTO> deviceerrorList) {
        this.deviceerrorList = deviceerrorList;
    }

    public List<DoctorDTO> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(List<DoctorDTO> doctorList) {
        this.doctorList = doctorList;
    }

    public List<DoctortypeDTO> getDoctortypeList() {
        return doctortypeList;
    }

    public void setDoctortypeList(List<DoctortypeDTO> doctortypeList) {
        this.doctortypeList = doctortypeList;
    }

    public List<MedicalaidDTO> getMedicalaidList() {
        return medicalaidList;
    }

    public void setMedicalaidList(List<MedicalaidDTO> medicalaidList) {
        this.medicalaidList = medicalaidList;
    }

    public List<PatientfileDTO> getPatientfileList() {
        return patientfileList;
    }

    public void setPatientfileList(List<PatientfileDTO> patientfileList) {
        this.patientfileList = patientfileList;
    }

    public List<ProvinceDTO> getProvinceList() {
        return provinceList;
    }

    public void setProvinceList(List<ProvinceDTO> provinceList) {
        this.provinceList = provinceList;
    }

    public List<ReceptionistDTO> getReceptionistList() {
        return receptionistList;
    }

    public void setReceptionistList(List<ReceptionistDTO> receptionistList) {
        this.receptionistList = receptionistList;
    }

    public List<ServererrorDTO> getServererrorList() {
        return servererrorList;
    }

    public void setServererrorList(List<ServererrorDTO> servererrorList) {
        this.servererrorList = servererrorList;
    }

    public List<SurgeryDTO> getSurgeryList() {
        return surgeryList;
    }

    public void setSurgeryList(List<SurgeryDTO> surgeryList) {
        this.surgeryList = surgeryList;
    }

    public List<TownshipDTO> getTownshipList() {
        return townshipList;
    }

    public void setTownshipList(List<TownshipDTO> townshipList) {
        this.townshipList = townshipList;
    }

    public List<VisitDTO> getVisitList() {
        return visitList;
    }

    public void setVisitList(List<VisitDTO> visitList) {
        this.visitList = visitList;
    }
}
