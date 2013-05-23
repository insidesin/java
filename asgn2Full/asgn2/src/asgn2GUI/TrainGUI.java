package asgn2GUI;

import asgn2Exceptions.TrainException;
import asgn2RollingStock.*;
import asgn2Train.DepartingTrain;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.border.EtchedBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.util.Stack;

public class TrainGUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = -7031008862559936404L;
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;

	private static final int LOCOMOTIVE_PAINT = 0;
	private static final int PASSENGERCAR_PAINT = 1;
	private static final int FREIGHTCAR_PAINT = 2;

	Stack<Canvas> carriagePanelStack;
	
	private JComboBox<String> cmbBoxCarriageType;
	private JLabel lblPowerClass;
	private JTextField txtBoxPowerInput;
	private JLabel lblSeatCount;
	private JSpinner txtBoxSeatInput;
	private JLabel lblGoodsType;
	private JTextField txtBoxGoodsInput;
	private JLabel lblWeight;
	private JSpinner txtBoxWeightInput;

	private JPanel carriagePanel;
	private JPanel carriageEditPanel;

	private DepartingTrain trainConfiguration;

	/**
	 * @param arg0
	 * @throws HeadlessException
	 * @throws TrainException
	 */
	public TrainGUI(String arg0) throws HeadlessException {
		super(arg0);
		createGUI();
		trainConfiguration = new DepartingTrain();
		carriagePanelStack = new Stack<Canvas>();
		// try {
		// trainConfiguration.addCarriage(new Locomotive(50, "4S"));
		// trainConfiguration.addCarriage(new PassengerCar(50, 20));
		// trainConfiguration.addCarriage(new FreightCar(50, "G"));
		// } catch (TrainException e) {
		// e.printStackTrace();
		// }
	}

	private void createGUI() {
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BorderLayout borderLayout = new BorderLayout();
		getContentPane().setLayout(borderLayout);

		JPanel setupViewContainer = new JPanel();
		setupViewContainer.setBorder(null);
		getContentPane().add(setupViewContainer, BorderLayout.NORTH);
		setupViewContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 15));

		JScrollPane carriageScrollPane = new JScrollPane();
		carriageScrollPane.setBorder(null);
		carriageScrollPane.setPreferredSize(new Dimension(750, 135));
		carriageScrollPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		setupViewContainer.add(carriageScrollPane);

		carriagePanel = new JPanel();
		carriageScrollPane.setViewportView(carriagePanel);
		carriagePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		// Canvas canvas_1 = new Canvas();
		// canvas_1.setPreferredSize(new Dimension(100, 100));
		// carriagePanel.add(canvas_1);
		// canvas_1.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		//
		// Canvas canvas_2 = new Canvas();
		// canvas_2.figure = 1;
		// canvas_2.setPreferredSize(new Dimension(100, 100));
		// carriagePanel.add(canvas_2);
		// canvas_2.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		//
		// Canvas canvas_3 = new Canvas();
		// canvas_3.figure = 2;
		// canvas_3.setPreferredSize(new Dimension(100, 100));
		// carriagePanel.add(canvas_3);
		// canvas_3.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		//
		// Canvas canvas_4 = new Canvas();
		// canvas_4.figure = 2;
		// canvas_4.setPreferredSize(new Dimension(100, 100));
		// carriagePanel.add(canvas_4);
		// canvas_4.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

		JPanel contentPanel = new JPanel();
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.X_AXIS));

		JPanel leftDriverPanel = new JPanel();
		contentPanel.add(leftDriverPanel);
		leftDriverPanel.setLayout(new BorderLayout(0, 0));

		JPanel leftDriverPanelFloatRight = new JPanel();
		leftDriverPanel.add(leftDriverPanelFloatRight, BorderLayout.EAST);
		leftDriverPanelFloatRight.setAlignmentX(Component.RIGHT_ALIGNMENT);
		leftDriverPanelFloatRight.setBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null));
		leftDriverPanelFloatRight.setPreferredSize(new Dimension(375, 10));
		leftDriverPanelFloatRight.setMinimumSize(new Dimension(350, 10));
		leftDriverPanelFloatRight.setLayout(new BorderLayout(0, 0));

		JPanel carriageInfoPanel = new JPanel();
		carriageInfoPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				null, null));
		FlowLayout fl_carriageInfoPanel = (FlowLayout) carriageInfoPanel
				.getLayout();
		fl_carriageInfoPanel.setVgap(25);
		fl_carriageInfoPanel.setHgap(25);
		leftDriverPanelFloatRight.add(carriageInfoPanel, BorderLayout.NORTH);

		carriageEditPanel = new JPanel();
		leftDriverPanelFloatRight.add(carriageEditPanel, BorderLayout.CENTER);
		carriageEditPanel.setLayout(null);

		// Select a carriage Type combo box
		cmbBoxCarriageType = new JComboBox<String>();
		cmbBoxCarriageType.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (cmbBoxCarriageType.getSelectedIndex() == 0) {
					hideNewCarriageInput();
					lblWeight.setVisible(false);
					txtBoxWeightInput.setVisible(false);
				} else if (cmbBoxCarriageType.getSelectedIndex() == 1) {
					hideNewCarriageInput();
					lblPowerClass.setVisible(true);
					txtBoxPowerInput.setVisible(true);
					lblWeight.setVisible(true);
					txtBoxWeightInput.setVisible(true);
				} else if (cmbBoxCarriageType.getSelectedIndex() == 2) {
					hideNewCarriageInput();
					lblSeatCount.setVisible(true);
					txtBoxSeatInput.setVisible(true);
					lblWeight.setVisible(true);
					txtBoxWeightInput.setVisible(true);
				} else if (cmbBoxCarriageType.getSelectedIndex() == 3) {
					hideNewCarriageInput();
					lblGoodsType.setVisible(true);
					txtBoxGoodsInput.setVisible(true);
					lblWeight.setVisible(true);
					txtBoxWeightInput.setVisible(true);
				}
			}
		});
		cmbBoxCarriageType.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Enter a carriage type.", "Locomotive",
						"PassengerCar", "FreightCar" }));
		cmbBoxCarriageType.setBounds(12, 97, 163, 25);
		carriageEditPanel.add(cmbBoxCarriageType);

		// PowerClass label
		lblPowerClass = new JLabel("Power class:");
		lblPowerClass.setVisible(false);
		lblPowerClass.setBounds(12, 134, 92, 16);
		carriageEditPanel.add(lblPowerClass);

		// PowerClass input box
		txtBoxPowerInput = new JTextField();
		txtBoxPowerInput.setVisible(false);
		txtBoxPowerInput.setBounds(12, 156, 163, 20);
		carriageEditPanel.add(txtBoxPowerInput);

		// Seat count label
		lblSeatCount = new JLabel("Seat count:");
		lblSeatCount.setVisible(false);
		lblSeatCount.setBounds(12, 134, 107, 16);
		carriageEditPanel.add(lblSeatCount);

		// Seat count input box
		txtBoxSeatInput = new JSpinner();
		txtBoxSeatInput.setVisible(false);
		txtBoxSeatInput.setBounds(12, 156, 163, 20);
		carriageEditPanel.add(txtBoxSeatInput);

		// Goods type label
		lblGoodsType = new JLabel("Goods Type:");
		lblGoodsType.setVisible(false);
		lblGoodsType.setBounds(12, 134, 124, 16);
		carriageEditPanel.add(lblGoodsType);

		// Goods type input box
		txtBoxGoodsInput = new JTextField();
		txtBoxGoodsInput.setVisible(false);
		txtBoxGoodsInput.setBounds(12, 156, 163, 20);
		carriageEditPanel.add(txtBoxGoodsInput);

		// Weight label
		lblWeight = new JLabel("Weight (kg):");
		lblWeight.setVisible(false);
		lblWeight.setBounds(187, 134, 124, 16);
		carriageEditPanel.add(lblWeight);

		// Weight input box
		txtBoxWeightInput = new JSpinner();
		txtBoxWeightInput.setVisible(false);
		txtBoxWeightInput.setBounds(187, 156, 163, 20);
		carriageEditPanel.add(txtBoxWeightInput);

		// Add Carriage to Train label
		JLabel lblAddCarriageTitle = new JLabel("Add a Carriage to Train:");
		lblAddCarriageTitle.setFont(new Font("Dialog", Font.BOLD, 14));
		lblAddCarriageTitle.setBounds(12, 67, 217, 25);
		carriageEditPanel.add(lblAddCarriageTitle);

		// Add Carriage button
		JButton btnAddCarriage = new JButton("Add Carriage");
		btnAddCarriage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Canvas newCarriageCanvas = new Canvas();

				try {
					if (cmbBoxCarriageType.getSelectedItem() == "Enter a carriage type.") {
						return;
					} else if (cmbBoxCarriageType.getSelectedItem() == "Locomotive") {
						trainConfiguration.addCarriage(new Locomotive(
								(Integer) txtBoxWeightInput.getValue(),
								txtBoxPowerInput.getText()));
						newCarriageCanvas.figure = LOCOMOTIVE_PAINT;
					} else if (cmbBoxCarriageType.getSelectedItem() == "PassengerCar") {
						trainConfiguration.addCarriage(new PassengerCar(
								(Integer) txtBoxWeightInput.getValue(),
								(Integer) txtBoxSeatInput.getValue()));
						newCarriageCanvas.figure = PASSENGERCAR_PAINT;
					} else if (cmbBoxCarriageType.getSelectedItem() == "FreightCar") {
						trainConfiguration.addCarriage(new FreightCar(
								(Integer) txtBoxWeightInput.getValue(),
								txtBoxGoodsInput.getText()));
						newCarriageCanvas.figure = FREIGHTCAR_PAINT;
					}
				} catch (TrainException e) {
					e.printStackTrace();
				}

				// Find the train recently created so we can work with it
				// multiple times.
				RollingStock currentCarriage = trainConfiguration
						.nextCarriage();

				// Display their text readable description.
				newCarriageCanvas.getCarriageLabel().setText(
						currentCarriage.toString());

				// Check their capacity and display progressBar accordingly.
				if (currentCarriage instanceof Locomotive) {
					newCarriageCanvas.getProgressBar().setMaximum(
							((Locomotive) currentCarriage).power());
					newCarriageCanvas.getProgressBar().setValue(
							currentCarriage.getGrossWeight());
				} else if (currentCarriage instanceof PassengerCar) {
					newCarriageCanvas.getProgressBar().setMaximum(
							((PassengerCar) currentCarriage).numberOfSeats());
				} else if (currentCarriage instanceof FreightCar) {
					newCarriageCanvas.getProgressBar().setMaximum(
							currentCarriage.getGrossWeight());
					newCarriageCanvas.getProgressBar().setValue(
							currentCarriage.getGrossWeight());
				}

//				//Add to logical list.
//				carriagePanelStack.push(newCarriageCanvas);
				
				carriagePanel.add(newCarriageCanvas);
				newCarriageCanvas.setLayout(new FlowLayout(FlowLayout.LEFT, 0,
						0));
				validate();
				repaint();
			}
		});
		btnAddCarriage.setBounds(12, 188, 163, 39);
		carriageEditPanel.add(btnAddCarriage);

		// Remove Carriage Button
		JButton btnRemoveCarriage = new JButton("Remove Carriage");
		btnRemoveCarriage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				try {
//					//Remove from both logical list and physical GUI.
//					if(!carriagePanelStack.isEmpty()) {
//						trainConfiguration.removeCarriage();
//						carriagePanel.remove(carriagePanelStack.peek());
//						carriagePanelStack.pop();
//					}
//					validate();
//					repaint();
//				} catch (TrainException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
			}
		});
		btnRemoveCarriage.setBounds(187, 188, 163, 39);
		carriageEditPanel.add(btnRemoveCarriage);

		JPanel panel_8 = new JPanel();
		contentPanel.add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel_8.add(panel_1, BorderLayout.WEST);
		panel_1.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setPreferredSize(new Dimension(375, 10));
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
		flowLayout_1.setVgap(25);
		flowLayout_1.setHgap(25);
		panel_1.add(panel_3, BorderLayout.NORTH);

		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_1.add(panel_6, BorderLayout.CENTER);

		JButton btnBoard = new JButton("Board");
		btnBoard.setBounds(12, 188, 99, 39);
		panel_6.add(btnBoard);

		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(196, 188, 163, 39);
		panel_6.add(btnReset);

		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Dialog", Font.BOLD, 14));
		spinner.setBounds(108, 188, 64, 39);
		panel_6.add(spinner);

		JLabel lblBoardPassengers = new JLabel("Board Passengers:");
		lblBoardPassengers.setFont(new Font("Dialog", Font.BOLD, 14));
		lblBoardPassengers.setBounds(12, 161, 160, 19);
		panel_6.add(lblBoardPassengers);

		// Exception Panel
		JPanel exceptionPanel = new JPanel();
		exceptionPanel.setPreferredSize(new Dimension(10, 100));
		getContentPane().add(exceptionPanel, BorderLayout.SOUTH);
		exceptionPanel.setLayout(new BorderLayout(5, 5));

		// Exception Panel label
		JLabel lblErrorConsole = new JLabel("Error console:");
		exceptionPanel.add(lblErrorConsole, BorderLayout.NORTH);

		// Exception Panel text box
		JTextPane exceptionTextPane = new JTextPane();
		exceptionTextPane.setEditable(false);
		exceptionTextPane.setToolTipText("Error messages");
		exceptionTextPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				null, null));
		exceptionPanel.add(exceptionTextPane);

	}

	private void hideNewCarriageInput() {
		lblGoodsType.setVisible(false);
		txtBoxGoodsInput.setVisible(false);
		lblSeatCount.setVisible(false);
		txtBoxSeatInput.setVisible(false);
		lblPowerClass.setVisible(false);
		txtBoxPowerInput.setVisible(false);
	}

	public void actionPerformed(ActionEvent e) {
		String buttonString = e.getActionCommand();

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TrainGUI gui = new TrainGUI("Departing Train");
		gui.setVisible(true);

	}

	public JPanel getCarriagePanel() {
		return carriagePanel;
	}
}
