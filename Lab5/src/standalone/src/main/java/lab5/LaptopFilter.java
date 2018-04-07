package lab5;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LaptopFilter {
    private String name;
    private String CPU;
    private String RAM;
    private String video_card;
    private String HDD;

    public LaptopFilter(){}

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

    public void setName(String name) {
        this.name = name;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public void setRAM(String RAM) {
        this.RAM = RAM;
    }

    public void setVideo_card(String video_card) {
        this.video_card = video_card;
    }

    public void setHDD(String HDD) {
        this.HDD = HDD;
    }
}
