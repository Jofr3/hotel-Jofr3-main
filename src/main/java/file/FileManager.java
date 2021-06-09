package file;

import moduls.ClientH;
import moduls.HabitacioH;
import moduls.ReservaH;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FileManager {
    File carpeta;
    File fitxer, llistaUsuaris;

    FileWriter fw;
    BufferedWriter bw;

    FileReader fr;
    BufferedReader br;

    public FileManager() {
        createFolder();
    }

    private void createFolder() {
        carpeta = new File("dades");
        if (carpeta.mkdir()) {
            System.out.println("FileManager - Dades: carpeta creada");
        } else {
            System.out.println("FileManager - Dades: ja esta creada");

        }
    }

    private void createFitxer(String nomFitxer) {
        fitxer = new File("dades" + File.separator + nomFitxer);
        if (fitxer.exists()) {
            System.out.println("FileManager - " + nomFitxer + ": ja esta creat");
        } else {
            try {
                if (fitxer.createNewFile()) {
                    System.out.println("FileManager - " + nomFitxer + ": fitxer creat");
                } else {
                    System.out.println("FileManager - " + nomFitxer + ": no s'ha pogut crear");
                }
            } catch (IOException e) {
                System.out.println("FileManager - " + nomFitxer + " ERROR: " + e.getMessage());
            }
        }
    }

    public void nouClient(ArrayList<ClientH> llistaClients) {
        try {
            createFitxer("llistaUsuaris.txt");
            fw = new FileWriter(fitxer, false);
            bw = new BufferedWriter(fw);

            for (int i = 0; i < llistaClients.size(); i++) {
                bw.write(llistaClients.get(i).getNom()+"-"+llistaClients.get(i).getCognom()+"-"+llistaClients.get(i).getDni());
                bw.write(System.lineSeparator());
            }

            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void nouHabitacio(ArrayList<HabitacioH> llistaHabitacions) {
        try {
            createFitxer("llistaHabitacions.txt");
            fw = new FileWriter(fitxer, false);
            bw = new BufferedWriter(fw);

            for (int i = 0; i < llistaHabitacions.size(); i++) {
                bw.write(llistaHabitacions.get(i).getPlanta()+"-"+llistaHabitacions.get(i).getNumero());
                bw.write(System.lineSeparator());
            }

            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void nouReserva(ArrayList<ReservaH> llistaReserves) {
        try {
            createFitxer("llistaReserves.txt");
            fw = new FileWriter(fitxer, false);
            bw = new BufferedWriter(fw);

            for (int i = 0; i < llistaReserves.size(); i++) {
                bw.write(llistaReserves.get(i).getNomClient()+"-"+llistaReserves.get(i).getCognomClient()+"-"+llistaReserves.get(i).getDni()+"-"+llistaReserves.get(i).getHabitacio()+"-"+llistaReserves.get(i).getData());
                bw.write(System.lineSeparator());
            }

            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void borrarClient(ClientH client) {
        File fileTemp = new File("dades" + File.separator + "temp.txt");

        try {
            fr = new FileReader(fitxer);
            br = new BufferedReader(fr);

            fw = new FileWriter(fileTemp);
            bw = new BufferedWriter(fw);

            String dniClient = client.getDni();

            String contentLine = "";
            while ((contentLine = br.readLine()) != null) {
                if (!contentLine.contains(dniClient)) {
                    bw.write(contentLine);
                    bw.write(System.lineSeparator());
                }
            }

            bw.close();
            br.close();
            fitxer.delete();
            fileTemp.renameTo(fitxer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void borrarHabitacio(HabitacioH habitacio) {
        File fileTemp = new File("dades" + File.separator + "temp1.txt");

        try {
            fr = new FileReader(fitxer);
            br = new BufferedReader(fr);

            fw = new FileWriter(fileTemp);
            bw = new BufferedWriter(fw);

            String contentLine = "";
            while ((contentLine = br.readLine()) != null) {
                if (!contentLine.contains(String.valueOf(habitacio))) {
                    bw.write(contentLine);
                    bw.write(System.lineSeparator());
                }
            }

            bw.close();
            br.close();
            fitxer.delete();
            fileTemp.renameTo(fitxer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void borrarReserva(ReservaH reserva) {
        File fileTemp = new File("dades" + File.separator + "temp2.txt");

        try {
            fr = new FileReader(fitxer);
            br = new BufferedReader(fr);

            fw = new FileWriter(fileTemp);
            bw = new BufferedWriter(fw);

            String contentLine = "";
            while ((contentLine = br.readLine()) != null) {
                if (!contentLine.contains(String.valueOf(reserva))) {
                    bw.write(contentLine);
                    bw.write(System.lineSeparator());
                }
            }

            bw.close();
            br.close();
            fitxer.delete();
            fileTemp.renameTo(fitxer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean comprovaDNI(String dni) {

        try {
            createFitxer("llistaUsuaris.txt");

            fr = new FileReader(fitxer);
            br = new BufferedReader(fr);

            String contentLine = "";
            while ((contentLine = br.readLine()) != null) {
                if (contentLine.contains(dni)) {
                    return true;
                }
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;

    }

    public void updateClient(ClientH clientOld, ClientH clientNew) {
        File fileTemp = new File("dades" + File.separator + "temp3.txt");

        try {
            createFitxer("llistaUsuaris.txt");

            fr = new FileReader(fitxer);
            br = new BufferedReader(fr);

            fw = new FileWriter(fileTemp);
            bw = new BufferedWriter(fw);

            String contentLine = "";
            while ((contentLine = br.readLine()) != null) {
                if (!contentLine.contains(String.valueOf(clientOld.getDni()))) {
                    bw.write(contentLine);
                    bw.write(System.lineSeparator());
                }else{
                    bw.write(clientNew.getNom()+"-"+clientNew.getCognom()+"-"+clientNew.getDni());
                    bw.write(System.lineSeparator());
                }
            }

            bw.close();
            br.close();
            fitxer.delete();
            fileTemp.renameTo(fitxer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ClientH> llistarClients(){
        ArrayList<ClientH> llistaClients = new ArrayList<ClientH>();

        try {
            createFitxer("llistaUsuaris.txt");

            fr = new FileReader(fitxer);
            br = new BufferedReader(fr);

            llistaClients = new ArrayList<ClientH>();

            String contentLine = "";
            while ((contentLine = br.readLine()) != null) {
                String[] client = contentLine.split("-");
                llistaClients.add(new ClientH(client[0],client[1],client[2]));
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return llistaClients;
    }

    public ArrayList<HabitacioH> llistarHabitacions(){
        ArrayList<HabitacioH> llistaHabitacions = new ArrayList<HabitacioH>();

        try {
            createFitxer("llistaHabitacions.txt");

            fr = new FileReader(fitxer);
            br = new BufferedReader(fr);

            llistaHabitacions = new ArrayList<HabitacioH>();

            String contentLine = "";
            while ((contentLine = br.readLine()) != null) {
                String[] habitacio = contentLine.split("-");
                llistaHabitacions.add(new HabitacioH(habitacio[0],Integer.parseInt(habitacio[1])));
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return llistaHabitacions;
    }

}
