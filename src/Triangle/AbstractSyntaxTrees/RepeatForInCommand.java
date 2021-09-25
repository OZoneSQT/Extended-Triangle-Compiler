package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class RepeatForInCommand extends Command {
    public RepeatForInCommand(Declaration invdAST, Command cAST_for_in, SourcePosition thePosition) {
        super(thePosition);

        IVD = invdAST;
        C = cAST_for_in;
    }


    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitRepeatForInCommand(this, o);
    }

    public Declaration IVD;
    public Command C;
}
