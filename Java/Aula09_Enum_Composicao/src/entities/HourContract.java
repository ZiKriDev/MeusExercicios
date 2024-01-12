package entities;

import java.util.Date;

public class HourContract {
    private Date date;
    private Double valuePerHour;
    private Integer hours;

    public HourContract() {}

    public HourContract(Date date, Double valuePerHour, Integer hours) {
        this.date = date;
        this.valuePerHour = valuePerHour;
        this.hours = hours;
    }

    public Date getDate() {
        return date;
    }

    public Double getValuePerHour() {
        return valuePerHour;
    }

    public Integer getHours() {
        return hours;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setValuePerHour(Double valuePerHour) {
        this.valuePerHour = valuePerHour;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    // Valor total do contrato
    public Double totalValue() {
        Double total = (Double) valuePerHour * hours;
        return total;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        HourContract hourContract = (HourContract) obj;

        return date.equals(hourContract.date) && valuePerHour.equals(hourContract.valuePerHour) && hours.equals(hourContract.hours);
    }
}
