package javase.enums;

/**
 * @author liyazhou1
 * @desc TODO
 * @date 2019/6/7
 */
public class EnumDemo {

    public static void main(String[] args) {
        TrafficLightSystem trafficLightSystem = new TrafficLightSystem();

        for (int i = 0; i < 10 ; i ++) {
            trafficLightSystem.changeLight();
        }

        Enum e = TrafficLight.GREEN;
        TrafficLight.class.getEnumConstants();

    }
}


class TrafficLightSystem {

    private TrafficLight trafficLight = TrafficLight.RED;

    public void changeLight() {
        TrafficLight nextLight = trafficLight.nextLight();
        System.out.println(trafficLight + " --> " + nextLight);
        trafficLight = nextLight;
    }

}

enum TrafficLight {
    RED {
        @Override
        public TrafficLight nextLight() {
            return GREEN;
        }
    },
    GREEN {
        @Override
        public TrafficLight nextLight() {
            return YELLOW;
        }
    },
    YELLOW {
        @Override
        public TrafficLight nextLight() {
            return RED;
        }
    };

    public abstract TrafficLight nextLight();
}