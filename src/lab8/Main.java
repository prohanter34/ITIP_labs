package lab8;

import lab8.DataProcessors.*;
import lab8.DataProcessors.SortProcessor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);
        System.out.println("Input:");
        System.out.println("(input path) (output path)");
        String inputStr = scaner.nextLine();
        String[] paths = inputStr.split(" ");
        for (String i : paths) {
            System.out.println(i);
        }
        DataManager manager = new DataManager();

        System.out.println("Choose processor:");
        System.out.println("'sort' 'count'");
        String command = scaner.nextLine();
        switch (command) {
            case "sort":
            {
                System.out.println("Choose what sort:");
                System.out.println("'currency' 'country'");
                String sortCommand = scaner.nextLine();
                switch (sortCommand) {
                    case "currency":
                    {
                        SortByCurrency processor = new SortByCurrency();
                        manager.registerDataProcessor(processor);
                        manager.loadData(paths[0]);
                        manager.processData();
                        break;
                    }
                    case "country":
                    {
                        SortByCountry processor = new SortByCountry();
                        manager.registerDataProcessor(processor);
                        manager.loadData(paths[0]);
                        manager.processData();
                        break;
                    }
                    default:
                    {
                        System.out.println("Incorrect input");
                        break;
                    }
                }
                break;
            }
            case "count":
            {
                System.out.println("Choose what count:");
                System.out.println("'avg currency' 'people of countries'");
                String countCommand = scaner.nextLine();
                switch (countCommand) {
                    case "avg currency":
                    {
                        CountCurrencyAVG processor = new CountCurrencyAVG();
                        manager.registerDataProcessor(processor);
                        manager.loadData(paths[0]);
                        manager.processData();
                        break;
                    }
                    case "people of countries":
                    {
                        CountByCountry processor = new CountByCountry();
                        manager.registerDataProcessor(processor);
                        manager.loadData(paths[0]);
                        manager.processData();
                        break;
                    }
                    default: {
                        System.out.println("Incorrect input");
                        break;
                    }
                }
                break;
            }
            default:
            {
                System.out.println("Incorrect input");
                break;
            }
        }
        scaner.close();
        manager.saveData(paths[1]);
    }
}
