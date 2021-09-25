package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class CondRestOfIf extends Command {
    public CondRestOfIf(Expression eAST, Command cAST, Command roifAST, SourcePosition thePosition) {
        super(thePosition);
        E = eAST;
        C = cAST;
        CIF = roifAST;
    }

    @Override
    public Object visit(Visitor v, Object o) { return v.visitCondRestOfIf(this, o); }

    public Expression E;
    public Command C;
    public Command CIF;
}
