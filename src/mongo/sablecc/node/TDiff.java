/* This file was generated by SableCC (http://www.sablecc.org/). */

package mongo.sablecc.node;

import mongo.sablecc.analysis.*;

@SuppressWarnings("nls")
public final class TDiff extends Token
{
    public TDiff()
    {
        super.setText("!=");
    }

    public TDiff(int line, int pos)
    {
        super.setText("!=");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TDiff(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTDiff(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TDiff text.");
    }
}
