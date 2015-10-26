package problem.renderers;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

import problem.components.IComponent;

public abstract class AbstractRendererFactory implements IRendererFactory {
	private Map<Class<? extends IComponent>, Class<? extends IRenderer>> componentToRenderer;

	public AbstractRendererFactory() {
		this.componentToRenderer = new HashMap<Class<? extends IComponent>, Class<? extends IRenderer>>();
		this.populate();
	}
	
	protected final void put(Class<? extends IComponent> cClazz, Class<? extends IRenderer> rClazz) {
		this.componentToRenderer.put(cClazz, rClazz);
	}
	
	public final Class<? extends IRenderer> get(Class<? extends IComponent> cClazz) {
		return this.componentToRenderer.get(cClazz);
	}

	@Override
	public IRenderer createRenderer(IComponent c) throws Exception {
		Class<? extends IRenderer> clazz = this.componentToRenderer.get(c.getClass());
		Constructor<? extends IRenderer> ctor = clazz.getDeclaredConstructor(IComponent.class);
		return ctor.newInstance(c);
	}
	
	protected abstract void populate();
}
