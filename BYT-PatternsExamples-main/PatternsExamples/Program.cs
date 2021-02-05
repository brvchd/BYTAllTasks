using PatternsExamples.Mediator;
using PatternsExamples.ObjectPool;
using System;

namespace PatternsExamples
{
    class Program
    {
        static void Main(string[] args)
        {
            //Example of object pool pattern
            Store store = new Store();
            store.employWorker();
            store.OrderEquipment();
            WorkSpace obj = store.objPool.GiveEquipmentWorker();

            Console.WriteLine("The value of the counter in the Warehouse class: " + store.objPool.counter);

            store.CheckThatWorkerWasFired(obj, true);

            Console.WriteLine(store.workers);

            store.FireAnEmployee(obj);

            Console.WriteLine("The value of the counter in the Warehouse class: " + store.objPool.counter);

            store.CheckThatWorkerWasFired(obj, false);

            Console.WriteLine(store.workers);

            //-----------------------------------------------------

            //Example of Mediator pattern

            ManagerMediator mediator = new ManagerMediator();
            Colleague customer = new CustomerColleague(mediator);
            Colleague programmer = new ProgrammerColleague(mediator);
            Colleague tester = new TesterColleague(mediator);
            mediator.Customer = customer;
            mediator.Programmer = programmer;
            mediator.Tester = tester;
            customer.Send("There is an order. We have to create a programm");
            programmer.Send("Programm is ready. Testing is required.");
            tester.Send("Programm has been tested successfully and ready to be sold.");

            Console.Read();
        }
    }
}
