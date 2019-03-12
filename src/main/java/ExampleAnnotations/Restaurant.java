package ExampleAnnotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

@Controller
public class Restaurant {
    @Autowired
    Tea tea;

    public Tea getTea() {
        return tea;
    }
//    @Autowired
//    public void setTea(Tea tea) {
//        this.tea = tea;
//    }
//    @Autowired
//    private Restaurant(Tea tea) {
//        this.tea = tea;
//    }
}
