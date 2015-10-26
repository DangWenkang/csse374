package problem.renderers;

import problem.components.IComponent;

public interface IRendererFactory {
	public IRenderer createRenderer(IComponent c) throws Exception;
}
