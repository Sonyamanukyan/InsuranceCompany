package application.model;

import lombok.Data;
import org.joda.time.DateTime;

@Data
public class Manager {

    private String name;
    private DateTime birthday;
}
