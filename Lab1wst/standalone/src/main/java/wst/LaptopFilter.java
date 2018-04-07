package wst;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LaptopFilter {
    private String name;
    private String CPU;
    private String RAM;
    private String video_card;
    private String HDD;

}