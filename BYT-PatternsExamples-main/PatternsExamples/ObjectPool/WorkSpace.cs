using System;

namespace PatternsExamples.ObjectPool
{
    public class WorkSpace : IWorkSpace
    {
        public void IfWorkerWasEmployed()
        {
            Console.WriteLine("Worker work in shop");
        }

        public void IfWorkerWasFired()
        {
            Console.WriteLine("The employee was released");
        }
    }
}
