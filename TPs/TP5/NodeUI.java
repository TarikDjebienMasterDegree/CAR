import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ScrollPaneConstants;

public class NodeUI extends JFrame {
	
	protected JList lnode, lfile ;
	protected JButton brefresh, bfiles, bupload ;
    //protected PeerImpl _peer ;
    //protected SharedDirectory _fs ;
	
    //	public NodeUI (String id, PeerImpl peer, SharedDirectory fs) {
	public NodeUI (String id) {
		super (id) ;
		//this._peer = peer ;
		//this._fs = fs ;
		this.init () ;
		this.pack () ;
		this.setVisible (true) ;
		this.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE) ;
	}
	
	public void init () {
		/* list of nodes */
		this.lnode = new JList () ;
		javax.swing.JScrollPane scrollPaneln = new javax.swing.JScrollPane(lnode);
		scrollPaneln.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		/* list of file for a selected node */
		this.lfile = new JList () ;
		javax.swing.JScrollPane scrollPanelf = new javax.swing.JScrollPane(lfile);
		scrollPanelf.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		javax.swing.JSplitPane splitPane = new javax.swing.JSplitPane(javax.swing.JSplitPane.HORIZONTAL_SPLIT,scrollPaneln,scrollPanelf);
		this.getContentPane () .add (splitPane, BorderLayout.CENTER) ;
		
		JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		/* button for refreshing node list */
		this.brefresh = new JButton ("Nodes") ;
		this.brefresh.addActionListener (new RefreshListener ()) ;
		p.add (this.brefresh) ;

		/* button for refreshing node list */
		this.bfiles = new JButton ("Files") ;
		this.bfiles.addActionListener (new FilesListener ()) ;
		p.add (this.bfiles) ;

		/* button for refreshing node list */
		this.bupload = new JButton ("Upload") ;
		this.bupload.addActionListener (new UploadListener ()) ;
		p.add (this.bupload) ;
		this.getContentPane () .add (p, BorderLayout.SOUTH) ;
	}
	
	class RefreshListener implements ActionListener {
		public void actionPerformed (ActionEvent evt) {
			try {
			    lnode.setListData(new String[0]);// _peer.directory () .keySet ().toArray());
				lfile.setListData(new String[0]);
			} catch (Exception e) {
				e.printStackTrace () ;
			}
		}
	}

	class FilesListener implements ActionListener {
		public void actionPerformed (ActionEvent evt) {
			try {
				lfile.setListData(new String[0]);
				String nname = (String)lnode.getSelectedValue () ;
				if (nname == null) return ;
				//	lfile.setListData(_peer.directory().get(nname).files());
			} catch (Exception e) {
				e.printStackTrace () ;
			}
		}
	}

	class UploadListener implements ActionListener {
		public void actionPerformed (ActionEvent evt) {
			try {
				String nname = (String) lnode.getSelectedValue () ;
				String fname = (String) lfile.getSelectedValue () ;
				if (nname == null || fname == null) return ;
				/* get the peer reference, then ask it the file */
				//Peer p = _peer.directory () .get (nname) ;
				//byte[] fvalue = p.getFile (fname) ;
				//_fs.put (fname, fvalue) ;
			} catch (Exception e) {
				e.printStackTrace () ;
			}
		}
	}


	public static void main (String args[]) {

	    //		if(args.length<4) {
	    //		System.err.println("usage : java EBidet id path isroot rootname");
	    //		System.exit(0);
	    //	}
		NodeUI UI = new NodeUI("essai");
		//NodeUII ui = new NodeUI (id,peer, fs) ;
		
	}
	
}
