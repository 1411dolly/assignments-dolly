package ExampleAnnotations;

import org.springframework.stereotype.Component;

@Component
public class Tea {
    String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
