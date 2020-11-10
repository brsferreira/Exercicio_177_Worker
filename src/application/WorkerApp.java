package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public final class WorkerApp {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Enter department name: ");
		String department = "Fisica";//sc.nextLine();
		System.out.println("Enter worker data: ");
		System.out.print("Name: ");
		String workerName = "Bruno";//sc.nextLine();
		System.out.println("Base salary: ");
		double baseSlary = 1200.00;//sc.nextDouble();
		System.out.println("Worker level: ");
		String workerLevel = sc.next().toUpperCase();

		// Instanciando o trabalhado Worker

		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSlary, new Department(department));

		System.out.printf("How many contracts to this worker? ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Enter contract #" + i + " data: ");
			System.out.printf("Inform contract date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.printf("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.printf("Duration (hours): ");
			int hours = sc.nextInt();
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);
		}

		System.out.println();
		System.out.printf("Enter moth and year to calculate income (MM/YYYY): ");
		String monthAndYear = sc.next();

		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));

		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));


	}// main

}// class
