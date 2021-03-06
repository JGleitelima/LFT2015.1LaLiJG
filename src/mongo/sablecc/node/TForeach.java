/* This file was generated by SableCC (http://www.sablecc.org/). */

package mongo.sablecc.node;

import mongo.sablecc.analysis.*;

@SuppressWarnings("nls")
public final class TForeach extends Token
{
    public TForeach()
    {
        super.setText("for each");
    }

    public TForeach(int line, int pos)
    {
        super.setText("for each");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TForeach(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTForeach(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TForeach text.");
    }
}
