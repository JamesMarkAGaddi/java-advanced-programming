package org.acumen.training.codes;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reflection {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// 3 ways to reflect a class to a pointer/var
		Class<?> repoClass = SavingsRepository.class; // get mo lang yung javac mo kanina then parse

		SavingsRepository repo = new SavingsRepository();
		Class<?> repoClass2 = repo.getClass();

		try {
			Class<?> repo3 = Class.forName("org.acumen.training.codes.SavingsRepository");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// Parsing the .class file

		// Field ==> term for attributes ganun public chuchu
		try {
			Field fieldNow = repoClass.getField("now"); // kapag public field tatawagin mo with the var name getField
			Field fieldAH = repoClass.getDeclaredField("accountHolders");

			Fetched fetched = fieldNow.getAnnotation(Fetched.class);
			if (fetched != null) {
				LocalDate now = (LocalDate) fieldNow.get(repo); // need mo ng instantiation dito as medium para
																// makapasok ka
				// sa class
				System.out.println(now);
				fieldNow.set(repo, LocalDate.of(2025, 1, 1));
				now = (LocalDate) fieldNow.get(repo);
				System.out.println(now);
			}

			Fetched fetched2 = fieldAH.getAnnotation(Fetched.class);
			if (fetched2 != null) {
				if (fetched2.kind().equals("list")) { // kung same to ng nakalagay sa annotation mo dun sya magttrue
					fieldAH.setAccessible(true);
					List<String> names = (List<String>) fieldAH.get(repo);
					System.out.println(names);
					// edit mo yung file then tawag again
					fieldAH.set(repo, Arrays.asList("Anna", "Lorna", "Fe"));
					names = (List<String>) fieldAH.get(repo);
					System.out.println(names);
				}
			}
			// using annotation - this is a 'marker'
			// also called decorator
			// @(annotation)
			// this is a specla kind of interface

			Method methodgetMN = repoClass.getMethod("getMergedNames");
			Test test = methodgetMN.getAnnotation(Test.class);

			if (test.disabled() == false) { // kung equls sya sa nakalagay sa annotation ng method
				String name = (String) methodgetMN.invoke(repo);
				System.out.println(name);
			}

			// kapag may private method
			Method methodWelcomeMethod = repoClass.getDeclaredMethod("welcome", String.class);
			Test test2 = methodgetMN.getAnnotation(Test.class);

			if (test2.disabled() == false) {
				methodWelcomeMethod.setAccessible(true);
				methodWelcomeMethod.invoke(repo, "Mabuhay Felepens");
			}

		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		// pure inspection na to
		// pwede ka na mag-explore dito sa loob ng mga classes and others

		Class<?> listClass = ArrayList.class;
		Field[] fields = listClass.getDeclaredFields();

		for (Field field : fields) {
			System.out.println(field.getName());
			System.out.println(Modifier.toString(field.getModifiers()));
			System.out.println(field.getType());
			System.out.println("-----------------------------------");
		}

	}
}
