package lab3;

public class Laptop {
    private int id;
    private String name;
    private String CPU;
    private String RAM;
    private String video_card;
    private String HDD;

    public Laptop() {}

    public Laptop(int id,
                  String name,
                  String CPU,
                  String RAM,
                  String video_card,
                  String HDD) {
        this.id = id;
        this.name = name;
        this.CPU = CPU;
        this.RAM = RAM;
        this.video_card = video_card;
        this.HDD = HDD;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getRAM() {
        return RAM;
    }

    public void setRAM(String RAM) {
        this.RAM = RAM;
    }

    public String getVideo_card() {
        return video_card;
    }

    public void setVideo_card(String video_card) {
        this.video_card = video_card;
    }

    public String getHDD() {
        return HDD;
    }

    public void setHDD(String HDD) {
        this.HDD = HDD;
    }

    @Override
    public String toString() {
        return String.format("Название: %s\n" +
                        "CPU: %s\n" +
                        "RAM: %s\n" +
                        "Видео карта: %s\n" +
                        "HDD: %s",
                this.name,
                this.CPU,
                this.RAM,
                this.video_card,
                this.HDD);
    }
}
