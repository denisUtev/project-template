package edu.hw6.Task6;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.util.HashMap;

public final class Task6 {

    private Task6() {

    }

    public static final int COUNT_PORTS = 49151;
    @SuppressWarnings("MagicNumber")
    public static final HashMap<Integer, String> TCP_PORTS = new HashMap<>() {{
        put(135, "EPMAP");
        put(139, "Служба сеансов NetBIOS");
        put(3306, "MySQL");
        put(445, "Microsoft-DS Active Directory");
        put(843, "Adobe Flash");
        put(27017, "MongoDB");
    }};

    @SuppressWarnings("MagicNumber")
    public static final HashMap<Integer, String> UDP_PORTS = new HashMap<>() {{
        put(137, "Служба имен NetBIOS");
        put(138, "Служба датаграмм NetBIOS");
        put(1900, "Simple Service Discovery Protocol (SSDP)");
        put(3702, "Динамическое обнаружение веб-служб");
        put(5353, "Многоадресный DNS");
        put(5355, "Link-Local Multicast Name Resolution (LLMNR)");
        put(17500, "Dropbox");
    }};

    @SuppressWarnings("RegexpSinglelineJava")
    public static void registrateAllPorts() {
        System.out.println("Протокол\tПорт\tСервис");
        for (int i = 0; i < COUNT_PORTS; i++) {
            try {
                ServerSocket serverSocket = new ServerSocket(i);
                if (TCP_PORTS.containsKey(i)) {
                    System.out.printf("TCP \t%d\n", i);
                }
            } catch (IOException e) {
                if (TCP_PORTS.containsKey(i)) {
                    System.out.printf("TCP \t%d \t%s\n", i, TCP_PORTS.get(i));
                }
            }
            try {
                DatagramSocket serverSocket = new DatagramSocket(i);
                if (UDP_PORTS.containsKey(i)) {
                    System.out.printf("UDP \t%d\n", i);
                }
            } catch (IOException e) {
                if (UDP_PORTS.containsKey(i)) {
                    System.out.printf("UDP \t%d \t%s\n", i, UDP_PORTS.get(i));
                }
            }
        }
    }
}
