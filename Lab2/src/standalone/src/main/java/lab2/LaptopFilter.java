package lab2;

public class LaptopFilter {
    private String name;
    private String CPU;
    private String RAM;
    private String video_card;
    private String HDD;

    public LaptopFilter(String name,
                  String CPU,
                  String RAM,
                  String video_card,
                  String HDD) {
        this.name = name;
        this.CPU = CPU;
        this.RAM = RAM;
        this.video_card = video_card;
        this.HDD = HDD;
    }

    public String getName() {
        return name;
    }

    public String getCPU() {
        return CPU;
    }

    public String getRAM() {
        return RAM;
    }

    public String getVideo_card() {
        return video_card;
    }

    public String getHDD() {
        return HDD;
    }
}
