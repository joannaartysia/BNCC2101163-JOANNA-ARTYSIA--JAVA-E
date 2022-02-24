
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Main {

	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	Vector<Karyawan> vKaryawan = new Vector<>();

	public Main() {
		menu();
	}

	int choose = 0;

	void menu() {
		do {
			System.out.println("PT MUSANG");
			System.out.println("1.Input data karyawan: ");
			System.out.println("2.View data karyawan: ");
			System.out.println("3.Update data karyawan: ");
			System.out.println("4.Delete data karyawan: ");
			System.out.println("5.EXIT>>");

			do {
				System.out.print("Choose: ");
				try {
					choose = scan.nextInt();
				} catch (Exception e) {
					System.out.println("Input must be numeric...");
				}
				scan.nextLine();
				System.out.println();
			} while (choose < 1 || choose > 5);

			switch (choose) {
			case 1:
				input();
				break;
			case 2:
				view();
				break;
			case 3:
				update();
				break;
			case 4:
				delete();
				break;
			case 5:
				System.out.println("Thankyou for using this application....");
				System.exit(0);
				break;
			}

		} while (choose != 5);
	}

	

	void input() {
		int gaji=0;
		String nama, kelamin, jabatan;
		rand();
		do {
			System.out.println("Input nama karyawan [>= 3]: ");
			nama = scan.nextLine();
		} while (nama.length() < 3);
		do {
			System.out.println("Input jenis kelamin [Laki-Laki | Perempuan] (Case Sensitive): ");
			kelamin = scan.nextLine();
		} while (kelamin.equals("Laki-Laki") == false && kelamin.equals("Perempuan") == false);

		do {
			System.out.println("Input Jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
			jabatan = scan.nextLine();
		} while (jabatan.equals("Manager") == false && jabatan.equals("Supervisor") == false
				&& jabatan.equals("Admin") == false);

		System.out.println("Berhasil menambahkan karyawan dengan id : " + idjadi);

		if (jabatan.equals("Manager")) {
			gaji = 8000000;
		} else if (jabatan.equals("Supervisor")) {
			gaji = 6000000;
		} else if (jabatan.equals("Admin")) {
			gaji = 4000000;
		}

		Karyawan newKaryawan = new Karyawan();
		newKaryawan.setKodeKaryawan(idjadi);
		newKaryawan.setNamaKaryawan(nama);
		newKaryawan.setJenisKelamin(kelamin);
		newKaryawan.setJabatan(jabatan);
		newKaryawan.setGajiKaryawan(gaji);
		vKaryawan.add(newKaryawan);

		String A, CEK = "Supervisor";
		int bonus1 = 0, Q, bonus;
		for (int k = 0; k < vKaryawan.size(); k++) {
			A = vKaryawan.get(k).getJabatan();
			if (CEK.equals(A)) {
				bonus1++;
			}
		}

		if (bonus1 >= 2) {
			if (bonus1 % 3 == 1) {
				for (int l = 0; l < vKaryawan.size(); l++) {
					Q = vKaryawan.get(l).getGajiKaryawan();
					A = vKaryawan.get(l).getJabatan();
					if (CEK.equals(A)) {
						newKaryawan.setGajiKaryawan(Q + Q / 40 * 3);
						vKaryawan.set(l, newKaryawan);
					}
				}
				bonus = bonus1 / 3;
				System.out.print("Bonus sebesar 7,5% telah diberikan kepada karyawan dengan id ");
				for (int i = 0; i < 3 * bonus; i++) {
					System.out.print(vKaryawan.get(i).getKodeKaryawan() + ", ");
				}
				System.out.println();
				System.out.println("press enter, please");
				scan.nextLine();
			}
		}

		String B, CEK2 = "Manager";
		int B1, bonus2 = 0;
		for (int k = 0; k < vKaryawan.size(); k++) {
			B = vKaryawan.get(k).getJabatan();
			if (CEK2.equals(B)) {
				bonus2++;
			}
		}
		if (bonus2 >= 2) {
			if (bonus2 % 3 == 1) {
				for (int l = 0; l < vKaryawan.size(); l++) {
					B1 = vKaryawan.get(l).getGajiKaryawan();
					B = vKaryawan.get(l).getJabatan();
					if (CEK2.equals(B)) {
						newKaryawan.setGajiKaryawan(B1 + B1 / 10);
						vKaryawan.set(l, newKaryawan);
					}
				}
				bonus = bonus2 / 3;
				System.out.print("Bonus sebesar 10% telah diberikan kepada karyawan dengan id ");
				for (int i = 0; i < 3 * bonus; i++) {
					System.out.print(vKaryawan.get(i).getKodeKaryawan() + ", ");
				}
				System.out.println();
				System.out.println("press enter, please");
				scan.nextLine();
			}
		}

		String C, CEK3 = "Admin";
		int C1, bonus3 = 0;
		for (int k = 0; k < vKaryawan.size(); k++) {
			C = vKaryawan.get(k).getJabatan();
			if (CEK3.equals(C)) {
				bonus3++;
			}
		}
		if (bonus3 >= 2) {
			if (bonus3 % 3 == 1) {
				for (int l = 0; l < vKaryawan.size(); l++) {
					C1 = vKaryawan.get(l).getGajiKaryawan();
					C = vKaryawan.get(l).getJabatan();
					if (CEK3.equals(C)) {
						newKaryawan.setGajiKaryawan(C1 + C1 / 20);
						vKaryawan.set(l, newKaryawan);
					}
				}
			}
		}

		bonus1 = 0;
		bonus3 = 0;
		bonus2 = 0;

	}

	int rand1, rand2;
	char temp;
	String q, w, r, idjadi;

	void rand() {
		rand1 = rand.nextInt(25) + 65;
		temp = (char) rand1;
		q = Character.toString(temp);
		rand1 = rand.nextInt(25) + 65;
		temp = (char) rand1;
		q = q.concat(Character.toString(temp));

		rand2 = rand.nextInt(9);
		r = Integer.toString(rand2);
		w = r;
		for (int j = 0; j < 3; j++) {
			rand2 = rand.nextInt(9);
			r = Integer.toString(rand2);
			w = w.concat(r);
		}
		idjadi = q + "-" + w;
		q = "";
		w = "";
	}

	void view() {
		if (vKaryawan.isEmpty()) {
			System.out.println("There is no data!");
		} else {
			viewData();
		}
	}

	String atas = "|%-4s|%-17s|%-30s|%-15s|%-14s|%-13s|%n";
	String bawah = "|%4d|%17s|%30s|%15s|%14s|%13d|%n";

	void viewData() {

		System.out.printf(
				"|----|-----------------|------------------------------|---------------|--------------|-------------|%n");
		System.out.printf(atas, "No", "Kode Karyawan", "Nama Karyawan", "Jenis Kelamin", "Jabatan", "Gaji Karyawan");
		System.out.printf(
				"|----|-----------------|------------------------------|---------------|--------------|-------------|%n");

		for (int i = 0; i < vKaryawan.size() - 1; i++) {
			for (int j = 0; j < vKaryawan.size() - i - 1; j++) {
				int nama1 = Character.getNumericValue(vKaryawan.get(j).getNamaKaryawan().charAt(0));
				int nama2 = Character.getNumericValue(vKaryawan.get(j + 1).getNamaKaryawan().charAt(0));
				if (nama1 > nama2) {
					Karyawan asd = vKaryawan.get(j);
					vKaryawan.set(j, vKaryawan.get(j + 1));
					vKaryawan.set(j + 1, asd);
				}
			}
		}

		for (int n = 0; n < vKaryawan.size(); n++) {
			System.out.printf(bawah, (n + 1), vKaryawan.get(n).getKodeKaryawan(), vKaryawan.get(n).getNamaKaryawan(),
					vKaryawan.get(n).getJenisKelamin(), vKaryawan.get(n).getJabatan(),
					vKaryawan.get(n).getGajiKaryawan());
		}

		System.out.printf(
				"|----|-----------------|------------------------------|---------------|--------------|-------------|%n");
                       
	}

	int index=0,gajiBaru=0;
	String namaBaru, jenisBaru, jabatanBaru;

	void update() {
		viewData();
		do {
			System.out.println("Input nomor urutan karyawan yang ingin diupdate: ");
			try {
				index = scan.nextInt();
			} catch (Exception e) {
				System.out.println("Input must be number!");
			}
			scan.nextLine();
		} while (index < 1 || index > vKaryawan.size());

		do {
			System.out.println("Input nama karyawan [>= 3]: ");
			namaBaru = scan.nextLine();
		} while (namaBaru.length() < 3);

		do {
			System.out.println("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
			jenisBaru = scan.nextLine();
		} while (jenisBaru.equals("Laki-laki") == false && jenisBaru.equals("Perempuan") == false);

		do {
			System.out.println("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
			jabatanBaru = scan.nextLine();
		} while (jabatanBaru.equals("Manager") == false && jabatanBaru.equals("Supervisor") == false
				&& jabatanBaru.equals("Admin") == false);

		System.out.println("Berhasil mengupdate karyawan dengan id " + vKaryawan.get(index - 1).getKodeKaryawan());

		
		if (jabatanBaru.equals("Manager")) {
			gajiBaru = 8000000;
		} else if (jabatanBaru.equals("Supervisor")) {
			gajiBaru = 6000000;
		} else if (jabatanBaru.equals("Admin")) {
			gajiBaru = 4000000;
		}
		Karyawan newKaryawan = new Karyawan();
		newKaryawan.setNamaKaryawan(namaBaru);
		newKaryawan.setJabatan(jabatanBaru);
		newKaryawan.setJenisKelamin(jenisBaru);
		newKaryawan.setKodeKaryawan(vKaryawan.get(index - 1).getKodeKaryawan());
		newKaryawan.setGajiKaryawan(gajiBaru);
		vKaryawan.set(index - 1, newKaryawan);
	}

	int inputdelete;

	void delete() {
		viewData();
		do {
			System.out.println("Input nomor urutan karyawan yang ingin dihapus: ");
			try {
				inputdelete = scan.nextInt();
			} catch (Exception e) {
				System.out.println("Input must be numeric...");
			}
			scan.nextLine();
		} while (inputdelete < 1 || inputdelete > vKaryawan.size());
		System.out.println("Karyawan dengan kode " + vKaryawan.get(inputdelete - 1).getKodeKaryawan() + " berhasil dihapus");
		vKaryawan.remove(inputdelete - 1);
		System.out.println("press enter , please");
		scan.nextLine();
	}

	public static void main(String[] args) {
		new Main();

	}

}
