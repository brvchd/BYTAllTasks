using System;
using System.Collections.Generic;
using System.Text;

namespace PatternsExamples.Mediator
{
    public class TesterColleague : Colleague
    {
        public TesterColleague(Mediator mediator) : base(mediator)
        { }

        public override void Notify(string message)
        {
            Console.WriteLine("Message to tester: " + message);
        }
    }
}
