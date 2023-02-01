public class AhriThread extends Thread {
    String skill_name;

    public AhriThread(String cmd) { // 생성자
        skill_name = cmd;
    }

    public void run() { // start() 메소드 사용 시
        System.out.println("시전한 스킬 : " + skill_name);

        for (int i = 1; i<=3; i++) {
            System.out.println(skill_name + " 스킬을 " + i + "초간 시전 중입니다..");
        }

        System.out.println("시전 끝난 스킬 : " + skill_name);
    }

    /* 스레드를 사용하면 한번에 여러 동작을 수행할 수 있다.
        다만, 쓰레드를 사용 시 주의할 점이자 단점은
        쓰레드로 한번에 많은 코드들을 수행할수록 컴퓨터에 부하가 심해지며
        쓰레드 수행 도중 내게 필요한 자원을 남이 가지고 있고
        남은 남에게 필요한 자원을 내가 가지고 있어서
        서로 무한정 대기하는 교착상태(Deadlock) 문제가 있으므로
        이에 주의해야 한다.
     */
    public static void main(String[] args) {
        String[] cmd = new String[] {"Q", "W", "E"};

        for (int i = 0; i<cmd.length; i++) {
            AhriThread a = new AhriThread(cmd[i]);
            a.start();
        }
    }
}