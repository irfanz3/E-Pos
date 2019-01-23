package entity;

import java.util.Date;

public class Request {

    private int id;
    private String office;
    private String letterNumber;
    private int status;
    private Date date;

    public static final int STATUS_APPROVE = 1;
    public static final int STATUS_PENDING = 2;
    public static final int STATUS_REJECT = 3;

    public Request(String letterNumber, String office, int status) {
        this.letterNumber = letterNumber;
        this.office = office;
        this.status = status;
        this.date = new Date();
    }

    public String getOffice() {
        return office;
    }

    public String getStatus() {
        switch (this.status) {
            case STATUS_APPROVE:
                return "Disetujui";
            case STATUS_PENDING:
                return "Menunggu";
            case STATUS_REJECT:
                return "Ditolak";
            default:
                return "Tidak Diketahui";
        }
    }

    public int getStatusInt() {
        return this.status;
    }

    public String getLetterNumber() {
        return letterNumber;
    }

    public Date getDate() {
        return date;
    }
}
