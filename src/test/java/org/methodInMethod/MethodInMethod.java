package org.methodInMethod;

public class MethodInMethod {

    public interface WhileDoingThat {
        void doThat();
    }

    class WhileSpecificThingToDo implements WhileDoingThat {

        @Override
        public void doThat() {

        }
    }

    public void methodForDoingThisWhileDoingGenericThat(WhileDoingThat whileDoingThat) {
        System.out.println("Do this.");
        whileDoingThat.doThat();
        System.out.println("Do after doing that.");
    }

    public void methodForDoingThisWhileDoingThat() {
        methodForDoingThisWhileDoingGenericThat(new WhileSpecificThingToDo());
    }
}
