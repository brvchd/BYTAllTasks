using System;

namespace PatternsExamples.Mediator
{
    class ProgrammerColleague : Colleague
    {
        public ProgrammerColleague(Mediator mediator) : base(mediator) { }
        
        public override void Notify(string message)
        {
            Console.WriteLine("Message to programmer: " + message);
        }
    }
}
