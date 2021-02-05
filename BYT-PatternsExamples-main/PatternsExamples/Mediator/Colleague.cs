namespace PatternsExamples.Mediator
{
    public abstract class Colleague
    {
        protected Mediator mediator;

        public Colleague(Mediator mediator)
        {
            this.mediator = mediator;
        }
        public abstract void Notify(string message);
        public virtual void Send(string message)
        {
            mediator.Send(message, this);
        }
    }
}
