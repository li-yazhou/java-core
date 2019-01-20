package org.alpha.javabase.javase.lang;

import org.junit.Test;

import java.util.Arrays;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-11 21:31
 */

/**
 * 带有抽象方法的枚举类
 */
enum WeekDay{
    SUNDAY(0){
        @Override
        public WeekDay nextDay() {
            return MONDAY;
        }
    }, MONDAY(1){
        @Override
        public WeekDay nextDay() {
            return TUESDAY;
        }
    }, TUESDAY(2) {
        @Override
        public WeekDay nextDay() {
            return WEDNESDAY;
        }
    }, WEDNESDAY(3) {
        @Override
        public WeekDay nextDay() {
            return THURSDAY;
        }
    }, THURSDAY(4) {
        @Override
        public WeekDay nextDay() {
            return FRIDAY;
        }
    }, FRIDAY(5) {
        @Override
        public WeekDay nextDay() {
            return SATURDAY;
        }
    }, SATURDAY(6) {
        @Override
        public WeekDay nextDay() {
            return SUNDAY;
        }
    };
    int day;
    WeekDay(int day){
        this.day = day;
    }

    public int day(){
        return day;
    }
    public abstract WeekDay nextDay();
}


enum TrafficLamp{
    RED(20) {
        @Override
        public TrafficLamp nextLamp() {
            return GREEN;
        }
    },
    GREEN(60) {
        @Override
        public TrafficLamp nextLamp() {
            return YELLOW;
        }
    },
    YELLOW(10) {
        @Override
        public TrafficLamp nextLamp() {
            return RED;
        }
    };

    int time;
    TrafficLamp(int time){
        this.time = time;
    }

    public abstract TrafficLamp nextLamp();
}

public class EnumTest {

    @Test
    public void test(){
        WeekDay weekDay = WeekDay.TUESDAY;
        WeekDay nextDay = weekDay.nextDay();
        System.out.println(weekDay);
        System.out.println(nextDay);

        WeekDay weekDay1 = WeekDay.valueOf("FRIDAY");
        System.out.println(weekDay1);
        System.out.println(weekDay1.name());
        System.out.println(weekDay1.ordinal());
        System.out.println(weekDay1.day());

        WeekDay[] weekDays = WeekDay.values();
        System.out.println(Arrays.toString(weekDays));
    }
}
