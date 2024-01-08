package bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class Admin {
	final static long bal = 2000;

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		do {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BANK", "root", "password");
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("Choose Option");
				System.out.println("1.Create An Admin(Bank Employee) Account\n2.Login Admin(Bank Employee) Account");
				int option = sc.nextInt();
				switch (option) {
				case 1: {
					System.out.println("Choose Option");
					System.out.println("1.Create An Account\n2.Update Account\n3.Delete Account");
					int choose = sc.nextInt();
					switch (choose) {
					case 1: {
						System.out.println("Enter id");
						int id = sc.nextInt();
						System.out.println("Enter Name");
						String name = sc.next();
						System.out.println("Enter MblNo");
						String mblno = sc.next();
						System.out.println("Enter DOB");
						String dob = sc.next();
						System.out.println("Enter Xender");
						String xender = sc.next();
						System.out.println("Enter Email");
						String email = sc.next();
						System.out.println("Enter password");
						String password = sc.next();
						System.out.println("Enter Qualification");
						String q = sc.next();
						PreparedStatement ps1 = con.prepareStatement(
								"insert into admin(id,name,mblno,dob,xender,email,password,qualifiation)values(?,?,?,?,?,?,?,?)");
						ps1.setInt(1, id);
						ps1.setString(2, name);
						ps1.setString(3, mblno);
						ps1.setString(4, dob);
						ps1.setString(5, xender);
						ps1.setString(6, email);
						ps1.setString(7, password);
						ps1.setString(8, q);
						ps1.addBatch();

						ps1.executeBatch();
						System.out.println("1 Bank Employee is added");
					}
						break;
					case 2: {
						System.out.println("Which Data you Want to Update");
						System.out.println("1.Id\n2.Name\n3.MblNo\n4.Dob\n5.Email\n6.Password");
						int n2 = sc.nextInt();
						switch (n2) {
						case 1: {
							PreparedStatement ps1 = con.prepareStatement("update admin set id=? where id=?");
							System.out.println("Enter your new id");
							int id1 = sc.nextInt();
							System.out.println("Enter your previous id which id you want to update");
							int id2 = sc.nextInt();
							ps1.setInt(1, id1);
							ps1.setInt(2, id2);
							int n1 = ps1.executeUpdate();
							System.out.println(n1 + " Data(id) updated");
							break;
						}
						case 2: {
							PreparedStatement ps1 = con.prepareStatement("update admin set name=? where id=?");
							System.out.println("Enter your new name");
							String id1 = sc.next();
							System.out.println("Enter your id which name you want to update");
							int id2 = sc.nextInt();
							ps1.setString(1, id1);
							ps1.setInt(2, id2);
							int n1 = ps1.executeUpdate();
							System.out.println(n1 + " Data(name) updated");
							break;
						}
						case 3: {
							PreparedStatement ps1 = con.prepareStatement("update admin set mblno=? where id=?");
							System.out.println("Enter your new MblNo");
							String id1 = sc.next();
							System.out.println("Enter your previous id which mblno you want to update");
							int id2 = sc.nextInt();
							ps1.setString(1, id1);
							ps1.setInt(2, id2);
							int n1 = ps1.executeUpdate();
							System.out.println(n1 + " Data(MblNo) updated");
							break;
						}
						case 4: {
							PreparedStatement ps1 = con.prepareStatement("update admin set dob=? where id=?");
							System.out.println("Enter your new Dob");
							String id1 = sc.next();
							System.out.println("Enter your previous id which dob you want to update");
							int id2 = sc.nextInt();
							ps1.setString(1, id1);
							ps1.setInt(2, id2);
							int n1 = ps1.executeUpdate();
							System.out.println(n1 + " Data(Dob) updated");
							break;
						}
						case 5: {
							PreparedStatement ps1 = con.prepareStatement("update admin set email=? where id=?");
							System.out.println("Enter your new Email");
							String id1 = sc.next();
							System.out.println("Enter your previous id which email you want to update");
							int id2 = sc.nextInt();
							ps1.setString(1, id1);
							ps1.setInt(2, id2);
							int n1 = ps1.executeUpdate();
							System.out.println(n1 + " Data(Email) updated");
							break;
						}
						case 6: {
							PreparedStatement ps1 = con.prepareStatement("update admin set password=? where id=?");
							System.out.println("Enter your new password");
							String id1 = sc.next();
							System.out.println("Enter your previous id which password you want to update");
							int id2 = sc.nextInt();
							ps1.setString(1, id1);
							ps1.setInt(2, id2);
							int n1 = ps1.executeUpdate();
							System.out.println(n1 + " Data(Password) updated");
							break;
						}
						}
						break;
					}
					case 3: {
						PreparedStatement ps6 = con.prepareStatement("delete from admin where id=?");
						System.out.println("Enter Which id you want to delete");
						int id = sc.nextInt();
						ps6.setInt(1, id);
						ps6.addBatch();
						int n = ps6.executeUpdate();
						System.out.println(n + " Record Deleted");
					}
					}
				}
					break;
				case 2: {

					PreparedStatement ps = con.prepareStatement("select * from admin where email=? and password=?");

					System.out.println("Enter email");
					String email = sc.next();
					System.out.println("Enter password");
					String password = sc.next();
					ps.setString(1, email);
					ps.setString(2, password);
					ResultSet rs = ps.executeQuery();
					if (rs.next()) {
						System.out.println("Login Sucessfully");
						System.out.println("Choose Option");
						System.out.println(
								"1.Add Customer\n2.View Customer By Account Number\n3.Block Customer By Account Number\n4.Unblock Customer By Account Number\n5.Update Customer\n6.Delete Customer\n7.Deposit Balance\n8.WithDraw");
						int choose = sc.nextInt();
						switch (choose) {
						case 1: {
							PreparedStatement ps2 = con.prepareStatement(
									"insert into customer(id,name,accountNo,pincode,balance,status)values(?,?,?,?,?,?)");
							System.out.println(
									"Enter Your Ammount Whatever You want to deposit your account bt our bank minimum deposit balance is ₹2000");
							long balance = sc.nextLong();
							if (bal <= balance) {
								System.out.println("Enter id");
								int id = sc.nextInt();
								System.out.println("Enter name");
								String name = sc.next();
								System.out.println("Account Number");
								long accno = generateRandomAccNO(12);
								System.out.println(accno);
								System.out.println("Pincode");
								long pincode = generateRandomPincode(6);
								System.out.println(pincode);
								System.out.println("Bank Deposit Balance");
								System.out.println(balance);
								System.out.println("Status Hint:-Active-true,o/w-false");
								boolean status = sc.nextBoolean();
								ps2.setInt(1, id);
								ps2.setString(2, name);
								ps2.setLong(3, accno);
								ps2.setLong(4, pincode);
								ps2.setLong(5, bal);
								ps2.setBoolean(6, status);

								ps2.addBatch();
								ps2.executeBatch();
								System.out.println("1 new Bank Account Opened");
								System.out.println("1 customer added");
							} else {
								System.out.println("Your Deposit Balance is very less to open your Account");
								System.out.println(
										"Please keep patience saving more ammount ,then you can create an account");
								System.out.println("Thank You Visit Again");
							}
						}
							break;
						case 2: {
							PreparedStatement ps3 = con.prepareStatement("select * from customer where accountNo=?");

							System.out.println("Enter the AccountNumber");
							long accNo = sc.nextLong();
							ps3.setLong(1, accNo);
							ps3.execute();

							System.out.println("Sucessfully login by AccNo");
							ResultSet rs1 = ps3.executeQuery();

							while (rs1.next()) {
								if (rs1.getBoolean(6)) {
									System.out.println("Your Account Details in Shown Below");
									System.out.println(rs1.getInt(1) + " " + rs1.getString(2) + " " + rs1.getLong(3)
											+ " " + rs1.getLong(4) + " " + rs1.getLong(5) + " " + rs1.getBoolean(6));
								} else {
									System.out.println("Your Account is Blocked");
								}
							}

						}
							break;
						case 3: {
							PreparedStatement ps4 = con
									.prepareStatement("update customer set status=? where accountNo=?");
							System.out.println("Enter Updated Bank Status");
							boolean status = sc.nextBoolean();
							ps4.setBoolean(1, status);
							System.out.println("Enter the AccountNumber");
							long accNo = sc.nextLong();
							ps4.setLong(2, accNo);
							if (status == false) {
								System.out.println("Your Account is Blocked");
							} else {

								System.out.println("Your Account is UnBlocked");
							}
							ps4.execute();

						}
							break;
						case 4: {

							PreparedStatement ps4 = con
									.prepareStatement("update customer set status=? where accountNo=?");
							System.out.println("Enter Updated Bank Status");
							boolean status = sc.nextBoolean();
							ps4.setBoolean(1, status);
							System.out.println("Enter the AccountNumber");
							long accNo = sc.nextLong();
							ps4.setLong(2, accNo);
							if (status == true) {
								System.out.println("Your Account is UnBlocked");
							} else {
								System.out.println("Your Account is Blocked");
							}
							ps4.execute();
						}
							break;
						case 5: {
							System.out.println("Which Data you Want to Update");
							System.out.println("1.id\n2.name\n3.Status");
							int n2 = sc.nextInt();
							switch (n2) {
							case 1: {
								PreparedStatement ps1 = con.prepareStatement("update customer set id=? where id=?");
								System.out.println("Enter your new id");
								int id1 = sc.nextInt();
								System.out.println("Enter your previous id which id you want to update");
								int id2 = sc.nextInt();
								ps1.setInt(1, id1);
								ps1.setInt(2, id2);
								int n1 = ps1.executeUpdate();
								System.out.println(n1 + " Data(id) updated");
								break;
							}
							case 2: {
								PreparedStatement ps1 = con.prepareStatement("update customer set name=? where id=?");
								System.out.println("Enter your new name");
								String id1 = sc.next();
								System.out.println("Enter your id which name you want to update");
								int id2 = sc.nextInt();
								ps1.setString(1, id1);
								ps1.setInt(2, id2);
								int n1 = ps1.executeUpdate();
								System.out.println(n1 + " Data(name) updated");
								break;
							}
							case 3: {
								PreparedStatement ps1 = con.prepareStatement("update customer set status=? where id=?");
								System.out.println("Enter your new status");
								boolean id1 = sc.nextBoolean();
								System.out.println("Enter your previous id which age you want to update");
								int id2 = sc.nextInt();
								ps1.setBoolean(1, id1);
								ps1.setInt(2, id2);
								int n1 = ps1.executeUpdate();
								System.out.println(n1 + " Data(status) updated");
								break;
							}
							default: {
								System.out.println("please enter valid Table column data");
								return;
							}

							}
						}
							break;
						case 6: {
							PreparedStatement ps6 = con.prepareStatement("delete from customer where id=?");
							System.out.println("Enter Which id you want to delete");
							int id = sc.nextInt();
							ps6.setInt(1, id);
							ps6.addBatch();
							int n = ps6.executeUpdate();
							System.out.println(n + " Record Deleted");
						}
							break;
						case 7: {
							PreparedStatement ps7 = con
									.prepareStatement("UPDATE customer SET balance = balance + ? WHERE accountNo = ?");
							System.out.println("Enter your AccountNo");
							long accNo = sc.nextLong();
							ps7.setLong(2, accNo);

							System.out.println("Enter How Much Amount to Deposit in your Account");
							long depositAmount = sc.nextLong();

							ps7.setLong(1, depositAmount);

							int n = ps7.executeUpdate();
							System.out.println(n + " Record Updated");
							System.out.println("Sucessfully Ammount Deposited");
						}
							break;
						case 8: {
							PreparedStatement ps7 = con
									.prepareStatement("UPDATE customer SET balance = balance - ? WHERE accountNo = ?");
							System.out.println("Enter your AccountNo");
							long accNo = sc.nextLong();
							ps7.setLong(2, accNo);

							System.out.println("Enter How Much Amount You Want To Withdraw in your Account");
							long WithdrawAmount = sc.nextLong();

							ps7.setLong(1, WithdrawAmount);

							int n = ps7.executeUpdate();
							System.out.println(n + " Record Updated");
							System.out.println("Sucessfully Ammount Debited");
						}
							break;

						default: {
							System.out.println("Invalid Credential");
						}
						}

					} else {
						System.out.println("Invalid Credential");
						System.out.println("Please Enter Correct Email And Password");
						System.out.println("If Enter Correct Email And Password Then Access It.");
					}
				}
				}

				System.out.println("Do You Want to Continue(YES/NO)");
				String ch = sc.next();
				if (!ch.equalsIgnoreCase("yes")) {
					System.out.println("Stop Thank You Use Again");
					break;
				}
				sc.close();
			} catch (Exception e) {
				System.out.println("Please Enter Correct Details");
			}
		} while (true);
	}

	public static long generateRandomAccNO(int length) {
		Random random = new Random();
		char[] digits = new char[length];
		digits[0] = (char) (random.nextInt(9) + '1');
		for (int i = 1; i < length; i++) {
			digits[i] = (char) (random.nextInt(10) + '0');
		}
		return Long.parseLong(new String(digits));
	}

	public static long generateRandomPincode(int length) {
		Random random = new Random();
		char[] digits = new char[length];
		digits[0] = (char) (random.nextInt(9) + '1');
		for (int i = 1; i < length; i++) {
			digits[i] = (char) (random.nextInt(10) + '0');
		}
		return Long.parseLong(new String(digits));
	}
}
