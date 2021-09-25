package Triangle.AbstractSyntaxTrees;

import Triangle.AbstractSyntaxTrees.Command;
import Triangle.AbstractSyntaxTrees.Expression;
import Triangle.AbstractSyntaxTrees.Visitor;
import Triangle.SyntacticAnalyzer.SourcePosition;

public class RepeatDoWhileCommand extends Command {
    public RepeatDoWhileCommand(Command cAST_do, Expression eAST_do, SourcePosition thePosition) {
        super(thePosition);
        C = cAST_do;
        E = eAST_do;
    }

    @Override
    public Object visit(Visitor v, Object o) { return v.visitRepeatDoWhileCommand(this, o); }

    public Command C;
    public Expression E;
}
